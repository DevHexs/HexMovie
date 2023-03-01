package com.hex.movie.data.network

import com.hex.movie.BuildConfig
import com.hex.movie.data.model.latest.MovieLatestData
import com.hex.movie.data.model.movie.MoviePageData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {
    @GET("movie/latest")
    suspend fun getLatestMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY_TMDB,
        @Query("language") language: String = "en-US"
    ):  Response<MovieLatestData>

    @GET("movie/popular")
    suspend fun getPopularsMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY_TMDB,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ):  Response<MoviePageData>

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY_TMDB,
        @Query("language") language: String = "en-US",
        @Query("query") query: String
    ): Response<MoviePageData>
}