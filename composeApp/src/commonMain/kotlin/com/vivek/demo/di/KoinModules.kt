package com.vivek.demo.di


import com.vivek.demo.data.remote.KtorApiService
import com.vivek.demo.data.remote.KtorApiServiceImpl
import com.vivek.demo.data.repo.NewsRepoImpl
import com.vivek.demo.domain.repo.NewsRepo
import com.vivek.demo.domain.usecase.GetNewsUseCase
import com.vivek.demo.ui.screens.news_screen.NewsViewModel
import com.vivek.demo.utils.Constants
import com.vivek.demo.utils.Constants.API_KEY
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json

import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {

    factory {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json {
                    ignoreUnknownKeys = true
                }, contentType = ContentType.Any
                    )
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 3000
                connectTimeoutMillis = 3000
                requestTimeoutMillis = 3000
            }
            install(Logging) {
                level = LogLevel.ALL
            }
//            install(Auth){
//                bearer {
//                    loadTokens {
//                        BearerTokens(
//                            accessToken = API_KEY,
//                            refreshToken = ""
//                        )
//                    }
//                }
//            }
            install(DefaultRequest) {
                url {
                    host = Constants.BASE_URL
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }

    factory<KtorApiService> {
        KtorApiServiceImpl(ktorClient = get())
    }

    factory<NewsRepo> {
        NewsRepoImpl(get())
    }

    factory {
        GetNewsUseCase(repo = get())
    }

    viewModel { NewsViewModel(newsUseCase = get()) }
}

expect fun sharedViewModelModule() : Module