package com.example.myhelpcompose.ui.components.appBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myhelpcompose.ui.components.space.ZetaSpaceWidth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZetaTopAppBar(
    modifier: Modifier = Modifier,
) {

    TopAppBar(
        title = { Text(text = "MyHelp") },
        navigationIcon = {
            Icon(imageVector = Icons.Default.Info, contentDescription = null)
        },
        actions = {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = Color.Black
            )
            ZetaSpaceWidth(10.dp)
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null)
            ZetaSpaceWidth(10.dp)
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.Blue)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Yellow,
            actionIconContentColor = Color.Red
        )

    )
}