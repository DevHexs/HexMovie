package com.hex.movie.domain

import com.hex.movie.data.model.popular.MoviePopularsData
import com.hex.movie.data.network.PopularMovieService
import javax.inject.Inject

class GetMoviePopularUseCase @Inject constructor(
    private val popularMovieService: PopularMovieService
) {
    suspend operator fun invoke(): MoviePopularsData = popularMovieService.getPopularMovie()
}