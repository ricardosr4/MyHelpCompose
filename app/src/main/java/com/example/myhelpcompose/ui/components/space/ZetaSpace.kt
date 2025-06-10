package com.example.myhelpcompose.ui.components.space

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ZetaSpaceHeight(size: Dp = 20.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun ZetaSpaceWidth(size: Dp = 20.dp){
    Spacer(modifier = Modifier.width(size))
}
