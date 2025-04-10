package com.example.core.api.service

import com.example.core.api.model.SearchResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET
    fun searchMovies(
        @Query("s") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = PAGE_SIZE,
        @Query("apikey") apikey: String = API_KEY,
    ): Response<SearchResponseDto>

    companion object {
        const val PAGE_SIZE = 10
        const val BASE_URL = "https://www.omdbapi.com/"
        const val API_KEY = "1a64ba7b"
    }
}
