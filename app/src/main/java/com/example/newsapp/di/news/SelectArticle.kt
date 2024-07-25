package com.example.newsapp.di.news

import com.example.newsapp.data.model.Article
import com.example.newsapp.data.remote.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {
     suspend operator fun invoke(url: String):Article?{
        return newsRepository.selectArticle(url)
    }
}