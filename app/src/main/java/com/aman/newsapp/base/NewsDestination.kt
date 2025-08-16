package com.aman.newsapp.base

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.aman.newsapp.R

sealed class Route(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val icon: Int,
    val routeWithoutArg: String = route
) {
    object TopNews : Route("topNews", R.string.news, R.drawable.ic_news)
    object FilterNews : Route("filterNews", R.string.filter, R.drawable.ic_filter)
    object SavedNews : Route("savedNews", R.string.saved, R.drawable.ic_save)
    object SearchNews : Route("searchNews", R.string.search, R.drawable.ic_search)
}

val bottomBarScreen = listOf(
    Route.TopNews,
    Route.FilterNews,
    Route.SavedNews,
    Route.SearchNews
)