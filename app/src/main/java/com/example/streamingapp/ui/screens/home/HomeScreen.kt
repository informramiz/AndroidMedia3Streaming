package com.example.streamingapp.ui.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.streamingapp.presentation.home.HomeViewModel
import com.example.streamingapp.ui.widgets.AppScaffold

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    AppScaffold(title = "Media3 Streaming") {
        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent() {
    Text(text = "Hello World")
}