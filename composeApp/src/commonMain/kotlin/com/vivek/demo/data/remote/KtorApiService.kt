package com.vivek.demo.data.remote

import com.vivek.demo.data.remote.dto.NewsResponseDto

interface KtorApiService {

    suspend fun getNews() : Resource<List<NewsResponseDto>>
    suspend fun getTopHeadlines(country: String = "us", pageSize: Int = 20): Resource<NewsResponseDto>

}