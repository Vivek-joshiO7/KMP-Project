package com.vivek.demo.data.repo

import com.vivek.demo.data.mapper.toDomainNews
import com.vivek.demo.data.remote.KtorApiService
import com.vivek.demo.data.remote.KtorApiServiceImpl
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.repo.NewsRepo

class NewsRepoImpl(private val ktorApiService: KtorApiService) : NewsRepo {


    override suspend fun getNews(): List<News> {
        return ktorApiService.getNews().map { it.toDomainNews() }
    }
}