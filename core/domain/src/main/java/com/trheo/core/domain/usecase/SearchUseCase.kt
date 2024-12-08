package com.trheo.core.domain.usecase

import com.trheo.core.domain.entity.BookInfo
import com.trheo.core.domain.repository.SearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend fun searchBooks(query: String): List<BookInfo> = searchRepository.searchBooks(query = query)
}