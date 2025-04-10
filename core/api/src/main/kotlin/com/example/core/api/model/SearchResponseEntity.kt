package com.example.core.api.model

import com.google.gson.annotations.SerializedName

data class SearchResponseEntity(
    @SerializedName("Search") val results: List<MovieEntity>,
    @SerializedName("totalResults") val totalResults: String,
    @SerializedName("Response") val response: String,
)
