package com.trheo.core.data.network

import com.trheo.core.data.network.service.GoogleBooksApi
import com.trheo.core.domain.entity.BookInfo
import com.trheo.core.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val api: GoogleBooksApi) : SearchRepository {
    override suspend fun searchBooks(query: String): List<BookInfo> {
        val response = api.searchBooks(query)
        return response.items?.map {
            BookInfo(
                title = it.volumeInfo.title,
                authors = it.volumeInfo.authors ?: emptyList(),
                publisher = it.volumeInfo.publisher ?: "Unknown",
                publishedDate = it.volumeInfo.publishedDate ?: "Unknown"
            )
        } ?: emptyList()
    }
}