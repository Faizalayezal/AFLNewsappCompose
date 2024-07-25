package com.example.newsapp.presentation.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.newsapp.data.model.Article
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.common.ArticleCard
import com.example.newsapp.presentation.common.EmptyScreen

@Composable
fun ArticleBookmarkList(
    modifier: Modifier = Modifier,
    article: List<Article>,
    onClick: (Article) -> Unit
) {

    if(article.isEmpty()){
        EmptyScreen()
    }

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            items(count = article.size) {
                article[it].let {
                    ArticleCard(article = it, onClick = { onClick(it) })
                }

            }

        }


}

