package com.example.myhelpcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myhelpcompose.presentation.home.screen.HomeScreen
import com.example.myhelpcompose.presentation.profile.screen.ProfileScreen
import com.example.myhelpcompose.presentation.search.screen.SearchScreen
import com.example.myhelpcompose.presentation.settings.screen.SettingsScreen
import com.example.myhelpcompose.presentation.favorites.screen.FavoritesScreen
import com.example.myhelpcompose.presentation.notifications.screen.NotificationsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }

        composable(Screen.Search.route) {
            SearchScreen(navController)
        }

        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }

        composable(Screen.Favorites.route) {
            FavoritesScreen(navController)
        }

        composable(Screen.Notifications.route) {
            NotificationsScreen(navController)
        }
    }
}