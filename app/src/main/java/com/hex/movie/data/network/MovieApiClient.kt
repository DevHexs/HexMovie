package com.hex.movie.data.network

import com.hex.movie.BuildConfig
import com.hex.movie.data.model.MovieLatestData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {
    @GET("movie/latest")
    suspend fun getLatestMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY_TMDB,
        @Query("language") language: String = "en-US"
    ):  Response<MovieLatestData>
}