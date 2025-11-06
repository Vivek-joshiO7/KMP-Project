package com.vivek.demo.domain.usecase

import com.vivek.demo.data.repo.NewsRepoImpl
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.repo.NewsRepo

class GetNewsUseCase(private val repo: NewsRepo) {

    suspend operator fun invoke() : List<News> = repo.getNews()

}