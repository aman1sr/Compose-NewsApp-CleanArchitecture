package com.aman.newsapp.repository

import com.aman.newsapp.Util.Const
import com.aman.newsapp.model.ApiArticle
import com.aman.newsapp.network.ApiInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getNewsByCountry(
        countryCode: String,
        pageNumber: Int = Const.DEFAULT_PAGE_NUM
    ): Flow<List<ApiArticle>> = flow {
        emit(
            apiInterface.getNews(
                countryCode,
                pageNum = pageNumber
            ).articles
        )
    }
}