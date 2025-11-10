package com.vivek.demo.domain.model

data class News(
    val totalResults: Int?,
    val articles: List<Article?>?

)

data class Article(
    val author: String?,

    val content: String?,

    val description: String?,

    val publishedAt: String?,

    val source: Source?,

    val title: String?,

    val url: String?,

    val imageUrl: String?
)
data class Source(
    val id: String?,
    val name: String?
)
