package com.hex.movie.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hex.movie.data.model.movie.MoviePageData
import com.hex.movie.domain.GetMoviePopularUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    private val getMoviePopularUseCase: GetMoviePopularUseCase
): ViewModel(){

    val moviePageData = MutableLiveData<MoviePageData>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            getMoviePopularUseCase().let {
                moviePageData.postValue(it)
                isLoading.postValue(false)
            }
        }
    }
}