package com.vivek.demo.di

import com.vivek.demo.data.remote.KtorApiServiceImpl
import com.vivek.demo.data.repo.NewsRepoImpl
import com.vivek.demo.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

val koinModule = module {

    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json {
                    ignoreUnknownKeys = true
                })
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 3000
                connectTimeoutMillis = 3000
                requestTimeoutMillis = 3000
            }

            install(DefaultRequest) {
                url {
                    host = Constants.BASE_URL
                    protocol = URLProtocol.HTTPS
                    headers { append(HttpHeaders.Authorization, Constants.API_KEY) }
                    contentType(ContentType.Application.Json)
                }
            }
        }
    }

    single {
        KtorApiServiceImpl(ktorClient = get())
    }

    single {
        NewsRepoImpl(ktorApiService = get())
    }
}

expect fun sharedViewModelModule() : Module