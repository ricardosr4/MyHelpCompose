package com.example.myhelpcompose.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myhelpcompose.presentation.components.navigation.TopBars.HuellaTopBar
import com.example.myhelpcompose.presentation.components.inputs.textFields.HuellaSearchBar
import com.example.myhelpcompose.presentation.components.inputs.chip.HuellaFiltersRow
import com.example.myhelpcompose.presentation.components.navigation.buttonBars.HuellaBottomBar

/**
 * Pantalla principal de Huella
 * Muestra el feed de mascotas con la bottom bar de navegación
 */
@Composable
fun HuellaScreen() {
    // Estado para controlar la ruta seleccionada
    var selectedRoute by remember { mutableStateOf("home") }
    // Estado para controlar el filtro seleccionado
    var selectedFilter by remember { mutableStateOf("todas") }

    Scaffold(
        // Configuramos el Scaffold para que consuma los insets de la barra de navegación
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            // Aplicamos el padding de la barra de navegación del sistema a la bottom bar
            Box(
                modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
            ) {
                HuellaBottomBar(
                    selectedRoute = selectedRoute,
                    onItemClick = { route ->
                        selectedRoute = route
                        // Aquí puedes agregar navegación real más adelante
                        // navController.navigate(route)
                    }
                )
            }
        }
    ) { paddingValues ->
        // Contenido principal del Feed
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
        ) {
            // Top Bar con título "Huella" y notificaciones
            // Aplicamos padding de la status bar para que no quede debajo de los iconos del sistema
            HuellaTopBar(
                modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
                onNotificationClick = {
                    // TODO: Navegar a notificaciones
                }
            )

            // Barra de búsqueda
            HuellaSearchBar(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                onSearch = { query ->
                    // TODO: Implementar búsqueda
                }
            )

            // Filtros horizontales
            HuellaFiltersRow(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                selectedFilterId = selectedFilter,
                onFilterSelected = { filterId ->
                    selectedFilter = filterId
                    // TODO: Filtrar contenido según el filtro seleccionado
                }
            )

            // Contenido temporal para visualizar
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Pantalla: ${getScreenTitle(selectedRoute)}",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "Filtro: $selectedFilter",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

/**
 * Helper para obtener el título de la pantalla según la ruta
 */
private fun getScreenTitle(route: String): String {
    return when (route) {
        "home" -> "Inicio"
        "favorites" -> "Favoritos"
        "publish" -> "Publicar"
        "foundation" -> "Fundación"
        "profile" -> "Perfil"
        else -> "Huella"
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHuellaScreen() {
    HuellaScreen()
}