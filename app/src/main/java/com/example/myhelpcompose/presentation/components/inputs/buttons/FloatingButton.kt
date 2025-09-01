package com.example.myhelpcompose.presentation.components.inputs.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingButtonExamples() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Floating Action Button (FAB)
        FloatingActionButton(onClick = { println("FAB Clicked") }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Small Floating Action Button
        SmallFloatingActionButton(onClick = { println("Small FAB Clicked") }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Large Floating Action Button
        LargeFloatingActionButton(onClick = { println("Large FAB Clicked") }) {
            Icon(imageVector = Icons.Filled.Share, contentDescription = "Share")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Extended Floating Action Button
        ExtendedFloatingActionButton(
            onClick = { println("Extended FAB Clicked") },
            text = { Text("Extended FAB") },
            icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Add") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Icon Button
        IconButton(onClick = { println("Icon Button Clicked") }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFloatingActionButtonExamples() {
    Column {
        FloatingButtonExamples()


    }
}
@Composable
fun MyFloatingActionButton(
    modifier: Modifier = Modifier,
) {
    FloatingActionButton(
        onClick = { println("FAB Clicked") },
        modifier = modifier
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}