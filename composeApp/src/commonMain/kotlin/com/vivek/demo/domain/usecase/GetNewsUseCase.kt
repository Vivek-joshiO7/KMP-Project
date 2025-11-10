package com.vivek.demo.domain.usecase

import com.vivek.demo.data.remote.Resource
import com.vivek.demo.data.remote.dto.NewsResponseDto
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.repo.NewsRepo

class GetNewsUseCase(private val repo: NewsRepo) {

    suspend operator fun invoke() : Resource<List<News>> = repo.getNews()

}