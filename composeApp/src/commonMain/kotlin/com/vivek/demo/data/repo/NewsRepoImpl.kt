package com.vivek.demo.data.repo

import com.vivek.demo.data.mapper.toDomain
import com.vivek.demo.data.remote.KtorApiService
import com.vivek.demo.data.remote.Resource
import com.vivek.demo.data.remote.dto.ArticleDto
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.repo.NewsRepo
import kotlinx.io.IOException

class NewsRepoImpl(private val ktorApiService: KtorApiService) : NewsRepo {


    override suspend fun getNews(): Resource<List<News>> {
        return try {
            when (val response = ktorApiService.getNews()) {
                is Resource.Success -> {
                    val newsList = response.data.map { newsResponseDto ->
                        newsResponseDto.toDomain()
                    }
                    Resource.Success(newsList)
                }

                is Resource.Error -> Resource.Error(response.message, response.code)
                is Resource.Loading -> Resource.Loading
            }
        } catch (e: IOException) {
            Resource.Error("Network error: ${e.message}")
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unexpected error occurred")
        }
    }
}