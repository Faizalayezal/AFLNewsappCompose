package com.example.newsapp.di.news

import com.example.newsapp.data.model.Article
import com.example.newsapp.data.remote.NewsRepository

class InsertArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.insertArticle(article)
    }
}