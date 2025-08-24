package com.aman.newsapp.network

import com.aman.newsapp.Util.Const.DEFAULT_COUNTRY
import com.aman.newsapp.Util.Const.DEFAULT_PAGE_NUM
import com.aman.newsapp.Util.Const.DEFAULT_QUERY_PAGE_SIZE
import com.aman.newsapp.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country : String = DEFAULT_COUNTRY,
        @Query("page") pageNum : Int = DEFAULT_PAGE_NUM,
        @Query("pageSize") pageSize : Int = DEFAULT_QUERY_PAGE_SIZE
    ) : News
}