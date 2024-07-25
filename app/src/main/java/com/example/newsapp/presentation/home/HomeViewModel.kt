package com.example.newsapp.presentation.home

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.BaseViewModel
import com.example.newsapp.di.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    newsUseCases: NewsUseCases
) : BaseViewModel(application) {

    val news = newsUseCases.getNews(source = listOf("bbc-news", "abc-news", "al-jazeera-english"))
        .cachedIn(viewModelScope)

}