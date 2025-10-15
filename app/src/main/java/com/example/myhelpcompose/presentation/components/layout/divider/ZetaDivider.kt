package com.example.myhelpcompose.presentation.components.layout.divider

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ZetaDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = colorScheme.outline.copy(alpha = 0.2f)
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}