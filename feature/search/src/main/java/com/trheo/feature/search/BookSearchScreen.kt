package com.trheo.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BookSearchScreen(viewModel: BookViewModel = hiltViewModel()) {
    val books by viewModel.books.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(modifier = Modifier.padding(16.dp).background(Color.White)) {
        var query by remember { mutableStateOf(TextFieldValue("")) }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            Button(onClick = { viewModel.searchBooks(query.text) }) {
                Text("Search")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text("Error: ${'$'}error", color = Color.Red)
        }

        LazyColumn {
            items(books) { book ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Title: ${book.title}")
                    Text("Authors: ${book.authors.joinToString(", ")}")
                    Text("Publisher: ${book.publisher}")
                    Text("Published: ${book.publishedDate}")
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}