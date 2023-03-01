package com.hex.movie.data.model.popular

import com.google.gson.annotations.SerializedName

data class MoviePopularsData (
    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<MoviePopularResultsData> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
)