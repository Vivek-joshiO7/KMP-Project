package com.vivek.demo.data.remote

import com.vivek.demo.data.remote.dto.NewsDto
import com.vivek.demo.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*

class KtorApiServiceImpl(private val ktorClient: HttpClient) : KtorApiService {


    override suspend fun getNews(): List<NewsDto> {
        return ktorClient.get(Constants.EVERYTHING_ENDPOINT).body<List<NewsDto>>()
    }
}