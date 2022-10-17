package com.ajcm.bottomnavigationexample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

const val MAIN_SCREEN = "main"
const val FAVORITE_SCREEN = "favorite"
const val SEARCH_SCREEN = "search"
const val SETTINGS_SCREEN = "settings"

@Composable
fun SetupNavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MAIN_SCREEN
    ) {
        composable(MAIN_SCREEN) {
            CreateScreenExample(title = "Main")
        }
        composable(FAVORITE_SCREEN) {
            CreateScreenExample(title = "Favorite")
        }
        composable(SEARCH_SCREEN) {
            CreateScreenExample(title = "Search")
        }
        composable(SETTINGS_SCREEN) {
            CreateScreenExample(title = "Settings")
        }
    }
}

@Composable
fun CreateScreenExample(title: String) {
    Text(
        text = title,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxSize()
    )
}
