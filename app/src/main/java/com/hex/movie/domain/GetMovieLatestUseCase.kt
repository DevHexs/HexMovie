package com.hex.movie.domain

import com.hex.movie.data.model.MovieLatestData
import com.hex.movie.data.network.LatestMovieService
import com.hex.movie.data.repo.LatestMovieRepository
import javax.inject.Inject

class GetMovieLatestUseCase @Inject constructor(
    private val latestMovieService: LatestMovieService)
{
    suspend operator fun invoke(): MovieLatestData = latestMovieService.getLatestMovie()
}