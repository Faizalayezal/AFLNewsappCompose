package com.example.newsapp.data.remote

import androidx.paging.PagingData
import com.example.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(source: List<String>): Flow<PagingData<Article>>
    fun searchNews(searchQuery: String, source: List<String>): Flow<PagingData<Article>>
    suspend fun insertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun selectArticles():Flow<List<Article>>
    suspend fun selectArticle(url: String):Article?

}