package com.vivek.demo.data.mapper

import com.vivek.demo.data.remote.dto.NewsDto
import com.vivek.demo.domain.model.News


fun NewsDto.toDomainNews() : News = News(
    title = this.articles?.let { articles[0]?.title } as String,
    summary = this.articles.let { articles[0]?.description } as String,
    publishedAt = this.articles.let { articles[0]?.publishedAt?:"" } as String
)