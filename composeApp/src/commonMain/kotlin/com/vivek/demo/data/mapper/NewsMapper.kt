package com.vivek.demo.data.mapper

import com.vivek.demo.data.remote.dto.ArticleDto
import com.vivek.demo.data.remote.dto.NewsResponseDto
import com.vivek.demo.data.remote.dto.SourceDto
import com.vivek.demo.domain.model.Article
import com.vivek.demo.domain.model.News
import com.vivek.demo.domain.model.Source


fun NewsResponseDto.toDomain(): News =
    News(
        totalResults = totalResults,
        articles = articleDtos?.map { it?.toDomain() }
    )

fun ArticleDto.toDomain(): Article =
    Article(
        source = sourceDto?.toDomain(),
        author = author.orEmpty(),
        title = title.orEmpty(),
        description = description.orEmpty(),
        url = url.orEmpty(),
        imageUrl = urlToImage,
        publishedAt = publishedAt,
        content = content.orEmpty()
    )

fun SourceDto.toDomain(): Source =
    Source(
        id = id,
        name = name
    )
