package com.example.myhelpcompose.presentation.components.navigation.buttonBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationButtonBar(
    modifier: Modifier = Modifier,
){
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
            label = { Text(text = "Favorite") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text(text = "Home") },
            alwaysShowLabel = false
        )
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
            label = { Text(text = "Settings") }
        )
    }
}