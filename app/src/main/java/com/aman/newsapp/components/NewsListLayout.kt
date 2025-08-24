package com.aman.newsapp.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.aman.newsapp.model.ApiArticle

@Composable
fun NewsLayout(
    newsList: List<ApiArticle>,
    articleClicked: (ApiArticle) -> Unit
) {
    LazyColumn {
        items(newsList){
            Article(it) { article ->
                articleClicked.invoke(article)
            }
        }

    }
}