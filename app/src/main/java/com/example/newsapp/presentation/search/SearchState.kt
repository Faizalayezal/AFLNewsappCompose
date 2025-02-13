package com.example.newsapp.presentation.search

import androidx.paging.PagingData
import com.example.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)