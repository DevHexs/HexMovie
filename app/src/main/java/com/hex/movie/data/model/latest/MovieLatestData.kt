package com.hex.movie.data.model.latest

import com.google.gson.annotations.SerializedName

data class MovieLatestData(
    val id: Int = 0,
    @SerializedName("original_title") val originalTitle: String = "",
    @SerializedName("poster_path") val imgUrl: String? = "",
    @SerializedName("overview") val overview: String = ""
)
