package com.aman.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.newsapp.Util.Const
import com.aman.newsapp.base.UIState
import com.aman.newsapp.model.ApiArticle
import com.aman.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    private val pageNum = Const.DEFAULT_PAGE_NUM
    private val _newItem = MutableStateFlow<UIState<List<ApiArticle>>>(UIState.Empty)
    val newsItem: StateFlow<UIState<List<ApiArticle>>> = _newItem

    init {
        fetchNewsbyCountry()
    }

     fun fetchNewsbyCountry(countryId: String = "us") {
        viewModelScope.launch {
            _newItem.emit(UIState.Loading)
            val response = newsRepository.getNewsByCountry(
                countryId ?: Const.DEFAULT_COUNTRY,
                pageNum
            )
            response.collect {
                _newItem.emit(UIState.Success(it))
                Log.d(TAG, "fetchNewsbyCountry: ${it}")
            }
        }
    }

    companion object {
        private val TAG = NewsViewModel::class.simpleName
    }
}