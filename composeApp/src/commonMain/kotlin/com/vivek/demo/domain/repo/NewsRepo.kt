package com.vivek.demo.domain.repo

import com.vivek.demo.data.remote.Resource
import com.vivek.demo.data.remote.dto.ArticleDto
import com.vivek.demo.data.remote.dto.NewsResponseDto
import com.vivek.demo.domain.model.News

interface NewsRepo {
    suspend fun getNews() : Resource<List<News>>
}