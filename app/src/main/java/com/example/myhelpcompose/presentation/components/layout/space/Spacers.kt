package com.example.myhelpcompose.presentation.components.layout.space

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer

@Composable
fun ZetaSpacerVertical(height: Dp = 16.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun ZetaSpacerHorizontal(width: Dp = 16.dp) {
    Spacer(modifier = Modifier.width(width))
}