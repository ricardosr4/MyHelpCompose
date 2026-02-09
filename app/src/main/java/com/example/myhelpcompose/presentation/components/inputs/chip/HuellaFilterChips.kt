package com.example.myhelpcompose.presentation.components.inputs.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Colores para los filtros de Huella
 */
private val HuellaPurple = Color(0xFF9C27B0)
private val HuellaWhite = Color.White

/**
 * Data class para representar un filtro
 */
data class HuellaFilter(
    val id: String,
    val label: String
)

/**
 * Chip individual de filtro estilo Huella
 *
 * @param label Texto del chip
 * @param isSelected Si el chip está seleccionado
 * @param onClick Callback cuando se hace click
 */
@Composable
fun HuellaFilterChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    
    val backgroundColor = if (isSelected) HuellaPurple else HuellaWhite
    val textColor = if (isSelected) HuellaWhite else HuellaPurple
    val borderColor = if (isSelected) HuellaPurple else HuellaPurple

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
        )
    }
}

/**
 * Row de filtros de Huella
 * Muestra los chips de filtro horizontalmente con scroll
 *
 * @param filters Lista de filtros disponibles
 * @param selectedFilterId ID del filtro seleccionado
 * @param onFilterSelected Callback cuando se selecciona un filtro
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaFiltersRow(
    filters: List<HuellaFilter> = defaultFilters,
    selectedFilterId: String = "todas",
    onFilterSelected: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filters) { filter ->
            HuellaFilterChip(
                label = filter.label,
                isSelected = filter.id == selectedFilterId,
                onClick = { onFilterSelected(filter.id) }
            )
        }
    }
}

/**
 * Filtros por defecto de la app Huella
 */
val defaultFilters = listOf(
    HuellaFilter("todas", "Todas"),
    HuellaFilter("perdidas", "Perdidas"),
    HuellaFilter("adopcion", "En adopción"),
    HuellaFilter("transito", "En tránsito"),
    HuellaFilter("emergencia", "En emergencia"),
    HuellaFilter("mapa", "Ver mapa")
)
