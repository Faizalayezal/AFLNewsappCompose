package com.example.newsapp.presentation.detail

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.newsapp.BaseViewModel
import com.example.newsapp.data.model.Article
import com.example.newsapp.di.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    application: Application,
    private val newsUseCases: NewsUseCases
) : BaseViewModel(application) {

    var sideEffect by mutableStateOf<String?>(null)
        //private set

    fun onEvent(event: DetailEvent){
        when(event){
            is DetailEvent.InsertDeleteArticle -> {
                viewModelScope.launch {
                    val article=newsUseCases.selectArticle(event.article.url)
                    if(article==null){
                        insertArticle(event.article)
                    }else{
                        deleteArticle(event.article)
                    }

                }
            }
            is DetailEvent.RemoveSideEffect -> {
                sideEffect=null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article=article)
        sideEffect="Article Deleted"
    }

    private suspend fun insertArticle(article: Article) {
        newsUseCases.insertArticle(article=article)
        sideEffect="Article Saved"
    }

}