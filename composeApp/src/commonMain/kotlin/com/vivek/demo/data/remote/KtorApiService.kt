package com.vivek.demo.data.remote

import com.vivek.demo.data.remote.dto.NewsDto

interface KtorApiService {

    suspend fun getNews() : List<NewsDto>

}