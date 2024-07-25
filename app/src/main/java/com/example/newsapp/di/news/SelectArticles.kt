package com.example.newsapp.di.news

import com.example.newsapp.data.model.Article
import com.example.newsapp.data.remote.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {
     operator fun invoke():Flow<List<Article>>{
        return newsRepository.selectArticles()
    }
}