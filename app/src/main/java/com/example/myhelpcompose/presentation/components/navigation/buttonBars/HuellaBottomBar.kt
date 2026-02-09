package com.example.myhelpcompose.presentation.components.navigation.buttonBars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Diversity3
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Colores de la app Huella
 */
private val HuellaPurple = Color(0xFF9C27B0)
private val HuellaWhite = Color.White
private val HuellaLightGray = Color(0xFFF5F5F5)

/**
 * Data class para los items de la bottom bar
 */
data class HuellaBottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

/**
 * Bottom Navigation Bar estilo Huella
 * Replica exactamente el diseño de la app con píldora para el item seleccionado
 *
 * @param selectedRoute Ruta actualmente seleccionada
 * @param onItemClick Callback cuando se hace click en un item
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaBottomBar(
    selectedRoute: String,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Definimos los items de navegación
    val items = listOf(
        HuellaBottomNavItem(
            title = "Inicio",
            icon = Icons.Filled.Home,
            route = "home"
        ),
        HuellaBottomNavItem(
            title = "Favoritos",
            icon = Icons.Filled.Favorite,
            route = "favorites"
        ),
        HuellaBottomNavItem(
            title = "Reportar",
            icon = Icons.Filled.Add,
            route = "publish"
        ),
        HuellaBottomNavItem(
            title = "Fundaciónes",
            icon = Icons.Outlined.Diversity3,
            route = "foundation"
        ),
        HuellaBottomNavItem(
            title = "Perfil",
            icon = Icons.Filled.Person,
            route = "profile"
        )
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
            .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
            .background(Color.LightGray)
            .padding(horizontal = 8.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            val isSelected = selectedRoute == item.route

            HuellaBottomNavItemView(
                item = item,
                isSelected = isSelected,
                onClick = { onItemClick(item.route) }
            )
        }
    }
}

/**
 * Vista individual de cada item de la bottom bar
 */
@Composable
private fun HuellaBottomNavItemView(
    item: HuellaBottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    if (isSelected) {
        // ITEM SELECCIONADO: Píldora morada con icono y texto
        Row(
            modifier = Modifier
                .background(
                    color = HuellaPurple,
                    shape = RoundedCornerShape(24.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onClick
                )
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = HuellaWhite,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = item.title,
                color = HuellaWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1
            )
        }
    } else {
        // ITEM NO SELECCIONADO: Solo el icono morado
        Box(
            modifier = Modifier
                .size(48.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onClick
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = HuellaPurple,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
