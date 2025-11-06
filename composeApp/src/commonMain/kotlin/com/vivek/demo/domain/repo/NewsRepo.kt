package com.vivek.demo.domain.repo

import com.vivek.demo.domain.model.News

interface NewsRepo {
    suspend fun getNews() : List<News>
}