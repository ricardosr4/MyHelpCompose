package com.example.myhelpcompose.presentation.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myhelpcompose.presentation.components.navigation.TopBars.HuellaTopBar
import com.example.myhelpcompose.presentation.components.inputs.textFields.HuellaSearchBar
import com.example.myhelpcompose.presentation.components.inputs.chip.HuellaFiltersRow
import com.example.myhelpcompose.presentation.components.navigation.buttonBars.HuellaBottomBar
import com.example.myhelpcompose.presentation.components.feed.HuellaPost
import com.example.myhelpcompose.presentation.components.feed.HuellaPostCard
import com.example.myhelpcompose.presentation.components.feed.PostStatus

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

            // Feed de mascotas
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                items(samplePosts.size) { index ->
                    val post = samplePosts[index]
                    HuellaPostCard(
                        post = post,
                        onLikeClick = {
                            // TODO: Implementar like
                        },
                        onCommentClick = {
                            // TODO: Implementar comentarios
                        },
                        onShareClick = {
                            // TODO: Implementar compartir
                        },
                        onSaveClick = {
                            // TODO: Implementar guardar
                        }
                    )
                    
                    // Espaciado entre posts
                    Spacer(modifier = Modifier.height(8.dp))
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

/**
 * Posts de ejemplo para el feed
 */
private val samplePosts = listOf(
    HuellaPost(
        id = "1",
        imageUrl = "https://images.unsplash.com/photo-1587300003388-59208cc962cb",
        likes = 23,
        comments = 1,
        isLiked = false,
        isSaved = false,
        status = PostStatus.ADOPTED,
        description = "Hola!! les comparto que estoy muy feliz de haber adoptado a Cachito, gracias a esta hermosa comunidad por haber ayudado a tenerlo. Chicos adopten, les cambia la vida, les juro!",
        timestamp = "Hace 2 horas"
    ),
    HuellaPost(
        id = "2",
        imageUrl = "https://images.unsplash.com/photo-1561037404-61cd46aa615b",
        likes = 45,
        comments = 8,
        isLiked = true,
        isSaved = false,
        status = PostStatus.IN_ADOPTION,
        description = "Hermoso cachorro en busca de hogar. Es muy juguetón y cariñoso. Necesita una familia que le de mucho amor.",
        timestamp = "Hace 5 horas"
    ),
    HuellaPost(
        id = "3",
        imageUrl = "https://images.unsplash.com/photo-1583511655857-d19b40a7a54e",
        likes = 12,
        comments = 3,
        isLiked = false,
        isSaved = true,
        status = PostStatus.LOST,
        description = "Se perdió en la zona de Providencia. Responde al nombre de Luna. Por favor ayúdenme a encontrarla.",
        timestamp = "Hace 1 día"
    )
)

@Preview(showBackground = true)
@Composable
fun PreviewHuellaScreen() {
    HuellaScreen()
}