package com.example.newsapp.data.remote

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class defaultrepository(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao

) : NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        Log.d("TAG", "getNews--->:1666 "+source)
        Log.d("TAG", "getNews--->:1777 "+source.joinToString(separator = ","))
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = source.joinToString(separator = ",")
                )
            }
        ).flow

    }

    override fun searchNews(searchQuery: String, source: List<String>): Flow<PagingData<Article>> {
        Log.d("TAG", "getNews--->:1666 "+source)
        Log.d("TAG", "getNews--->:1777 "+source.joinToString(separator = ","))
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery=searchQuery,
                    newsApi = newsApi,
                    sources = source.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun insertArticle(article: Article) {
        newsDao.insert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)

    }

    override fun selectArticles(): Flow<List<Article>> {
       return newsDao.getArticles()
    }

    override suspend fun selectArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }
}