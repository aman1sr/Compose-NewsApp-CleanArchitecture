package com.aman.newsapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aman.newsapp.R
import com.aman.newsapp.base.ShowError
import com.aman.newsapp.base.UIState
import com.aman.newsapp.base.showLoading
import com.aman.newsapp.components.NewsLayout
import com.aman.newsapp.model.ApiArticle
import com.aman.newsapp.viewmodel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    modifier: Modifier,
    newsViewModel: NewsViewModel = hiltViewModel(),
) {
    val newsUiState: UIState<List<ApiArticle>> by newsViewModel.newsItem.collectAsStateWithLifecycle()
    //todo: Material 3 PullRefresh (https://developer.android.com/reference/kotlin/androidx/compose/material3/pulltorefresh/PullToRefreshState)
    val pullRefreshState = rememberPullToRefreshState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (newsUiState) {
            is UIState.Success -> {
                val newsList =
                    (newsUiState as UIState.Success<List<ApiArticle>>).data.filterArticles()
                if (newsList.isEmpty()) {
                    ShowError(text = stringResource(R.string.no_data_available))
                } else {
                    NewsLayout(newsList = newsList) {
                        // handle news clicked info
                        Log.d("NewsScreen", "news Detail: ${it.title}")
                    }
                }
            }

            is UIState.Loading -> {
                showLoading()
            }

            is UIState.Failure -> {
                var errorText = stringResource(R.string.something_went_wrong)
                if ((newsUiState as UIState.Failure<List<ApiArticle>>).throwable is Exception) {
                    errorText = stringResource(id = R.string.no_internet_available)
                }
                ShowError(
                    text = errorText,
                    retryEnable = true
                ) {
                    newsViewModel.fetchNewsbyCountry()
                }
            }

            is UIState.Empty -> {

            }
        }
    }
}

fun List<ApiArticle>.filterArticles(): List<ApiArticle> {
    return this.filterNot { article ->
        article.title.isNullOrEmpty() || article.description.isNullOrEmpty() || article.urlToImage.isNullOrEmpty()
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen(
        modifier = Modifier.fillMaxSize()
    )
}