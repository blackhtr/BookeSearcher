package com.trheo.core.data.network.service

import com.trheo.core.data.network.data.GoogleBooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApi {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): GoogleBooksResponse
}