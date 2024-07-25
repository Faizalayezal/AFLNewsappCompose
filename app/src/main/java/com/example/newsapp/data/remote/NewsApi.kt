package com.example.newsapp.data.remote

import com.example.newsapp.data.model.NewsResponse
import com.example.newsapp.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apikey: String = API_KEY,
    ): Response<NewsResponse>


    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apikey: String = API_KEY,
    ): Response<NewsResponse>

}