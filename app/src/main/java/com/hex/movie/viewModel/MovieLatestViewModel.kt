package com.hex.movie.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hex.movie.data.model.MovieLatestData
import com.hex.movie.domain.GetMovieLatestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieLatestViewModel @Inject constructor(
    private val getMovieLatestUseCase: GetMovieLatestUseCase
): ViewModel() {
    val movieLatest = MutableLiveData<MovieLatestData>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            getMovieLatestUseCase().let {
                movieLatest.postValue(it)
                isLoading.postValue(false)
            }
        }
    }
}