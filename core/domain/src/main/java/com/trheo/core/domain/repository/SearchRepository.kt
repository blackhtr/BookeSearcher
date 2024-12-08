package com.trheo.core.domain.repository

import com.trheo.core.domain.entity.BookInfo

interface SearchRepository {
    suspend fun searchBooks(query: String): List<BookInfo>
}