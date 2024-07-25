package com.example.newsapp

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.dataStoreGetGroupPopup
import com.example.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {

    var splashCondition by mutableStateOf(true)

    var startDestination by mutableStateOf(Route.NewsNavigation.route)

    init {

        viewModelScope.launch {
            context.dataStoreGetGroupPopup().collect { shouldStartFromHomeScreen ->
                Log.d("TAG", "onadsdasdsadCreate:32 " + shouldStartFromHomeScreen)

                if (!shouldStartFromHomeScreen) {
                    startDestination = Route.AppStartNavigation.route


                } else {
                    startDestination = Route.NewsNavigation.route

                }
                delay(300)
                splashCondition = false
            }
        }


    }


}