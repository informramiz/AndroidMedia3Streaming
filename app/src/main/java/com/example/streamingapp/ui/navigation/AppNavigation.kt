package com.example.streamingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.streamingapp.ui.screens.AppScreen
import com.example.streamingapp.ui.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.Home.name) {
        composable(AppScreen.Home.name) {
            HomeScreen(navController = navController, viewModel = hiltViewModel())
        }
    }
}