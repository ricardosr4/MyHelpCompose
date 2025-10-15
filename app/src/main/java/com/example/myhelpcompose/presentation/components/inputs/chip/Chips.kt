package com.example.myhelpcompose.presentation.components.inputs.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * ZetaChip - Chip básico reutilizable
 */
@Composable
fun ZetaChip(
    text: String,
    selected: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    FilterChip(
        onClick = onClick,
        label = { Text(text) },
        selected = selected,
        modifier = modifier,
        enabled = enabled
    )
}

/**
 * ZetaChip con icono
 */
@Composable
fun ZetaChipWithIcon(
    text: String,
    icon: ImageVector,
    selected: Boolean = false,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    FilterChip(
        onClick = onClick,
        label = { Text(text) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        selected = selected,
        modifier = modifier,
        enabled = enabled
    )
}

/**
 * ZetaChip con botón de cerrar
 */
@Composable
fun ZetaChipDismissible(
    text: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    AssistChip(
        onClick = { },
        label = { Text(text) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Cerrar",
                modifier = Modifier.size(18.dp)
            )
        },
        modifier = modifier,
        enabled = enabled
    )
}

/**
 * ZetaChip de sugerencia
 */
@Composable
fun ZetaSuggestionChip(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    SuggestionChip(
        onClick = onClick,
        label = { Text(text) },
        modifier = modifier,
        enabled = enabled
    )
}

@Preview(showBackground = true)
@Composable
private fun ZetaChipPreview() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ZetaChip(text = "Chip Normal")
        ZetaChip(text = "Chip Seleccionado", selected = true)
        ZetaChipWithIcon(
            text = "Con Icono",
            icon = Icons.Default.Close,
            selected = true
        )
        ZetaChipDismissible(
            text = "Eliminable",
            onDismiss = { }
        )
    }
}