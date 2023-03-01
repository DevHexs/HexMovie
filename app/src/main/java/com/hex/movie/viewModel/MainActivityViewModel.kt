package com.hex.movie.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hex.movie.data.model.movie.MoviePageData
import com.hex.movie.domain.GetMovieSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getMovieSearchUseCase: GetMovieSearchUseCase
): ViewModel() {
    val moviePageData = MutableLiveData<MoviePageData>()
    val isLoading = MutableLiveData<Boolean>()

    fun onSearch(value: String){
        viewModelScope.launch {
            isLoading.postValue(true)
            getMovieSearchUseCase(value).let {
                moviePageData.postValue(it)
                isLoading.postValue(false)
            }
        }
    }
}