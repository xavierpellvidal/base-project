package com.example.core.api.model

import com.google.gson.annotations.SerializedName

data class SearchResponseDto(
    @SerializedName("Search") val results: List<MovieDto>,
    @SerializedName("totalResults") val totalResults: String,
    @SerializedName("Response") val response: String,
)
