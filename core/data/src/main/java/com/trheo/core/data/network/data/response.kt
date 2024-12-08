package com.trheo.core.data.network.data

data class GoogleBooksResponse(val items: List<BookItem>?)
data class BookItem(val volumeInfo: VolumeInfo)
data class VolumeInfo(val title: String, val authors: List<String>?, val publisher: String?, val publishedDate: String?)