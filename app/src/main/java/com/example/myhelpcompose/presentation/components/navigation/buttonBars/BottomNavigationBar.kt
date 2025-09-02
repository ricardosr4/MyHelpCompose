package com.example.myhelpcompose.presentation.components.navigation.buttonBars

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * BottomNavigationBar reutilizable y configurable
 *
 * @param items Lista de items de navegación
 * @param selectedIndex Índice del item seleccionado (0 por defecto)
 * @param onItemClick Callback cuando se hace click en un item
 * @param modifier Modifier para personalizar el componente
 */
@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    items: List<BottomNavItem>,
    selectedIndex: Int = 0,
    onItemClick: (Int) -> Unit,

    ) {
    var selectedItem by remember { mutableIntStateOf(selectedIndex) }

    NavigationBar(
        modifier = modifier
            //aqui le damos un redondeo a la bottom bar
            .clip(RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            ),
        //aqui manejamos el color de la bottom bar
        containerColor = Color(0xFF748CEC)

    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onItemClick(index)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                alwaysShowLabel = item.alwaysShowLabel
            )
        }
    }
}

/**
 * Data class para representar un item de navegación
 *
 * @param title Título del item
 * @param icon Icono del item
 * @param alwaysShowLabel Si siempre mostrar el label (true) o solo cuando está seleccionado (false)
 */
data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val alwaysShowLabel: Boolean = false
)

/**
 * Items predefinidos comunes para usar en diferentes apps
 */
object BottomNavItems {
    val HOME = BottomNavItem(
        title = "Inicio",
        icon = Icons.Default.Home
    )

    val SEARCH = BottomNavItem(
        title = "Buscar",
        icon = Icons.Default.Search
    )

    val FAVORITES = BottomNavItem(
        title = "Favoritos",
        icon = Icons.Default.Favorite
    )

    val PROFILE = BottomNavItem(
        title = "Perfil",
        icon = Icons.Default.Person
    )

    val SETTINGS = BottomNavItem(
        title = "Configuración",
        icon = Icons.Default.Settings,
//        alwaysShowLabel = true // siempre mostrar label
    )
}