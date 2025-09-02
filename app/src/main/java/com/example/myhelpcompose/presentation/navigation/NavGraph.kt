package com.example.myhelpcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myhelpcompose.presentation.home.screen.HomeScreen
import com.example.myhelpcompose.presentation.profile.screen.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}