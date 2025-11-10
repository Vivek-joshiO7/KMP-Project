package com.vivek.demo.data.remote

import com.vivek.demo.data.remote.dto.NewsResponseDto
import com.vivek.demo.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KtorApiServiceImpl(private val ktorClient: HttpClient) : KtorApiService {


    override suspend fun getNews(): Resource<List<NewsResponseDto>> {
        return withContext(Dispatchers.Default){
            try {
                val response: HttpResponse = ktorClient.get("/v2/everything") {
                    parameter("q", "technology")
                    parameter("sortBy", "publishedAt")
                    parameter("apiKey", Constants.API_KEY)
                    header(HttpHeaders.Accept, "application/json")
                }

                val statusCode = response.status.value
                if (statusCode in 200..299) {
                    val body = response.body<NewsResponseDto>()
                    Resource.Success(listOf(body))
                } else {
                    Resource.Error("HTTP $statusCode", statusCode)
                }
            } catch (t: Throwable) {
                Resource.Error(t.message ?: "Unknown error")
            }
        }
    }

    override suspend fun getTopHeadlines(country: String, pageSize: Int): Resource<NewsResponseDto> {
        return withContext(Dispatchers.Default) {
            try {
                val response: HttpResponse = ktorClient.get("/v2/top-headlines") {
                    parameter("country", country)
                    parameter("pageSize", pageSize)
                    header(HttpHeaders.Authorization, "Bearer ${Constants.API_KEY}")
                    header(HttpHeaders.Accept, "application/json")
                }

                val statusCode = response.status.value
                if (statusCode in 200..299) {
                    val body = response.body<NewsResponseDto>()
                    Resource.Success(body)
                } else {
                    Resource.Error("HTTP $statusCode", statusCode)
                }
            } catch (t: Throwable) {
                Resource.Error(t.message ?: "Unknown error")
            }
        }
    }
}