package com.example.newsapp.presentation.bookmark

import com.example.newsapp.data.model.Article

data class BookmarkState(
    val article: List<Article> = emptyList()
)