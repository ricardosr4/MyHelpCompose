package com.example.myhelpcompose.presentation.components.navigation.drawers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Navigation Drawer reutilizable y configurable
 *
 * @param items Lista de items del drawer
 * @param selectedItem Título del item seleccionado
 * @param onItemClick Callback cuando se hace click en un item
 * @param modifier Modifier para personalizar el componente
 * @param headerContent Contenido del header (opcional)
 * @param footerContent Contenido del footer (opcional)
 */
@Composable
fun NavigationDrawer(
    items: List<DrawerItem>,
    selectedItem: String,
    onItemClick: (DrawerItem) -> Unit,
    modifier: Modifier = Modifier,
    headerContent: @Composable (() -> Unit)? = null,
    footerContent: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Header
        headerContent?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                it()
            }
        }

        // Items del drawer
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(items) { item ->
                if (item.isDivider) {
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                    )
                } else {
                    DrawerItem(
                        item = item,
                        isSelected = selectedItem == item.title,
                        onClick = { onItemClick(item) }
                    )
                }
            }
        }

        // Footer
        footerContent?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                it()
            }
        }
    }
}

/**
 * Item individual del Navigation Drawer
 */
@Composable
private fun DrawerItem(
    item: DrawerItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        Color.Transparent
    }

    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    val iconColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Título
        Text(
            text = item.title,
            color = textColor,
            fontSize = 16.sp,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
            modifier = Modifier.weight(1f)
        )

        // Badge (si existe)
        item.badgeCount?.let { count ->
            if (count > 0) {
                Badge(
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onError
                ) {
                    Text(
                        text = if (count > 99) "99+" else count.toString(),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

/**
 * Items predefinidos comunes para usar en diferentes apps
 */
object DrawerItems {
    val HOME = DrawerItem(
        title = "Inicio",
        icon = Icons.Default.Home
    )

    val PROFILE = DrawerItem(
        title = "Perfil",
        icon = Icons.Default.Person
    )

    val SETTINGS = DrawerItem(
        title = "Configuración",
        icon = Icons.Default.Settings
    )

    val FAVORITES = DrawerItem(
        title = "Favoritos",
        icon = Icons.Default.Favorite
    )

    val SEARCH = DrawerItem(
        title = "Buscar",
        icon = Icons.Default.Search
    )

    val NOTIFICATIONS = DrawerItem(
        title = "Notificaciones",
        icon = Icons.Default.Notifications,
        badgeCount = 3
    )

    val HELP = DrawerItem(
        title = "Ayuda",
        icon = Icons.Default.Help
    )

    val ABOUT = DrawerItem(
        title = "Acerca de",
        icon = Icons.Default.Info
    )

    val LOGOUT = DrawerItem(
        title = "Cerrar Sesión",
        icon = Icons.Default.ExitToApp
    )

    // Separadores
    val DIVIDER = DrawerItem(
        title = "",
        icon = Icons.Default.Home,
        isDivider = true
    )
}
/**
 * Data class para representar un item del Navigation Drawer
 *
 * @param title Título del item
 * @param icon Icono del item
 * @param route Ruta de navegación (opcional)
 * @param isSelected Si el item está seleccionado
 * @param badgeCount Contador de badge (opcional, para notificaciones)
 * @param isDivider Si es un separador visual
 */
data class DrawerItem(
    val title: String,
    val icon: ImageVector,
    val route: String? = null,
    val isSelected: Boolean = false,
    val badgeCount: Int? = null,
    val isDivider: Boolean = false
)