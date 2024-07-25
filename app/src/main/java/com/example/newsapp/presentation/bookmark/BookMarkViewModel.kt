package com.example.newsapp.presentation.bookmark

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.newsapp.BaseViewModel
import com.example.newsapp.di.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    application: Application,
    private val newsUseCases: NewsUseCases
) : BaseViewModel(application) {

    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getArticles()
    }

    private fun getArticles(){
        newsUseCases.selectArticles().onEach {
            _state.value=_state.value.copy(article = it.asReversed())
        }.launchIn(viewModelScope)
    }
}