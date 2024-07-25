package com.example.newsapp.di.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.remote.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository

) {
    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}