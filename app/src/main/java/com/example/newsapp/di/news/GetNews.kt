package com.example.newsapp.di.news

import androidx.paging.PagingData
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.remote.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(source:List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(source = source)
    }

}