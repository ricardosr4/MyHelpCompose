package com.example.myhelpcompose.presentation.settings.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myhelpcompose.presentation.components.inputs.buttons.MyFloatingActionButton
import com.example.myhelpcompose.presentation.components.navigation.TopBars.MenuItem
import com.example.myhelpcompose.presentation.components.navigation.TopBars.TopAppBar
import com.example.myhelpcompose.presentation.components.navigation.buttonBars.BottomNavItems
import com.example.myhelpcompose.presentation.components.navigation.buttonBars.BottomNavigationBar
import com.example.myhelpcompose.presentation.components.navigation.drawers.DrawerItems
import com.example.myhelpcompose.presentation.components.navigation.drawers.NavigationDrawer
import com.example.myhelpcompose.presentation.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(
    navController: NavController
){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedDrawerItem by remember { mutableStateOf("Inicio") }
    val snackBackHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var currentTab by remember { mutableIntStateOf(3) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawer(
                items = listOf(
                    DrawerItems.HOME,
                    DrawerItems.PROFILE,
                    DrawerItems.SETTINGS,
                    DrawerItems.DIVIDER,
                    DrawerItems.NOTIFICATIONS,
                    DrawerItems.LOGOUT
                ),
                selectedItem = selectedDrawerItem,
                onItemClick = { item ->
                    selectedDrawerItem = item.title
                    when (item.route) {
                        "logout" -> {
                            // Lógica de logout aquí
                        }
                        else -> {
                            item.route?.let { route ->
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    }
                    scope.launch {
                        drawerState.close()
                    }
                },
                headerContent = {
                    Column {
                        Text(
                            text = "Mi App",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "usuario@email.com",
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                }
            )
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),

            topBar = {
                TopAppBar(
                    title = "Configuración",
                    showMenuButton = true,
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    showMoreButton = true,
                    menuItems = listOf(
                        MenuItem(
                            title = "Configuración",
                            icon = Icons.Default.Settings,
                            route = Screen.Settings.route,
                            isAction = false
                        ),
                        MenuItem(
                            title = "Cerrar sesión",
                            icon = Icons.AutoMirrored.Filled.ExitToApp,
                            route = "logout",
                            isAction = true,
                            action = {
                                // Tu lógica de logout aquí
                            }
                        )
                    ),
                    onMenuItemClick = { menuItem ->
                        navController.navigate(menuItem.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            },
            snackbarHost = { SnackbarHost(hostState = snackBackHostState) },

            floatingActionButton = { MyFloatingActionButton() },

            floatingActionButtonPosition = FabPosition.Center,

            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItems.HOME,
                        BottomNavItems.SEARCH,
                        BottomNavItems.PROFILE,
                        BottomNavItems.SETTINGS,
                        BottomNavItems.FAVORITES
                    ),
                    selectedIndex = currentTab,
                    onItemClick = { index ->
                        currentTab = index
                        val route = when (index) {
                            0 -> Screen.Home.route
                            1 -> Screen.Search.route
                            2 -> Screen.Profile.route
                            3 -> Screen.Settings.route
                            else -> Screen.Favorites.route
                        }
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Pantalla de Configuración",
                    modifier = Modifier.clickable {
                        scope.launch {
                            snackBackHostState.showSnackbar(
                                message = "Configurando...",
                                actionLabel = "guardar"
                            )
                        }
                    }
                )
            }
        }
    }
}
