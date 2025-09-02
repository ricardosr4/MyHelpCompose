package com.example.myhelpcompose.presentation.components.navigation.TopBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * TopAppBar reutilizable y configurable
 *
 * @param title Título de la barra
 * @param showBackButton Si mostrar botón de retroceso
 * @param showMenuButton Si mostrar botón de menú
 * @param showMoreButton Si mostrar botón de más opciones
 * @param onBackClick Callback para botón de retroceso
 * @param onMenuClick Callback para botón de menú
 * @param onMoreClick Callback para botón de más opciones
 * @param menuItems Lista de items del menú desplegable
 * @param onMenuItemClick Callback para items de navegación (no acciones)
 * @param modifier Modifier para personalizar el componente
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    showBackButton: Boolean = false,
    showMenuButton: Boolean = false,
    showMoreButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    onMenuClick: (() -> Unit)? = null,
    onMoreClick: (() -> Unit)? = null,
    menuItems: List<MenuItem> = emptyList(),
    onMenuItemClick: ((MenuItem) -> Unit)? = null,

) {
    var showDropdownMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            when {
                showBackButton -> {
                    IconButton(onClick = { onBackClick?.invoke() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
                showMenuButton -> {
                    IconButton(onClick = { onMenuClick?.invoke() }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú"
                        )
                    }
                }
            }
        },
        actions = {
            if (showMoreButton) {
                IconButton(onClick = { showDropdownMenu = true }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Más opciones"
                    )
                }
                DropdownMenu(
                    expanded = showDropdownMenu,
                    onDismissRequest = { showDropdownMenu = false }
                ) {
                    menuItems.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item.title) },
                            onClick = {
                                if (item.isAction && item.action != null) {
                                    // ← NUEVO: Ejecutar función directamente si es una acción
                                    item.action()
                                } else {
                                    // ← CAMBIADO: Solo llamar a onMenuItemClick para navegación
                                    onMenuItemClick?.invoke(item)
                                }
                                showDropdownMenu = false
                            },
                            leadingIcon = {
                                item.icon?.let { icon ->
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = modifier
    )
}

/**
 * Data class para representar un item del menú
 */
data class MenuItem(
    val title: String,
    val icon: ImageVector? = null,
    val route: String,  // ← Siempre requerido
    val isAction: Boolean = false,  // ← NUEVO: true = función, false = navegación
    val action: (() -> Unit)? = null  // ← NUEVO: función si isAction = true
)