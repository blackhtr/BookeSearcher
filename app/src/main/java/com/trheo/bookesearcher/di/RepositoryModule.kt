package com.trheo.bookesearcher.di

import com.trheo.core.data.network.SearchRepositoryImpl
import com.trheo.core.data.network.service.GoogleBooksApi
import com.trheo.core.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSearchRepository(apiService: GoogleBooksApi): SearchRepository {
        return SearchRepositoryImpl(apiService)
    }
}