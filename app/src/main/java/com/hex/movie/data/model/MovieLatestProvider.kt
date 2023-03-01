package com.hex.movie.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieLatestProvider @Inject constructor() {
    var movieLatest = MovieLatestData()
}