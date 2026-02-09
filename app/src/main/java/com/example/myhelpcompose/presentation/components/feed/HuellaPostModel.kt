package com.example.myhelpcompose.presentation.components.feed

/**
 * Modelo de datos para un post del feed de Huella
 */
data class HuellaPost(
    val id: String,
    val imageUrl: String,
    val likes: Int,
    val comments: Int,
    val isLiked: Boolean = false,
    val isSaved: Boolean = false,
    val status: PostStatus? = null,
    val description: String,
    val timestamp: String
)

/**
 * Estados posibles de un post
 */
enum class PostStatus {
    ADOPTED,      // Adoptado
    LOST,         // Perdida
    IN_ADOPTION,  // En adopción
    IN_TRANSIT,   // En tránsito
    EMERGENCY     // En emergencia
}

/**
 * Extensión para obtener el texto del estado
 */
fun PostStatus.toDisplayText(): String {
    return when (this) {
        PostStatus.ADOPTED -> "Adoptado"
        PostStatus.LOST -> "Perdida"
        PostStatus.IN_ADOPTION -> "En adopción"
        PostStatus.IN_TRANSIT -> "En tránsito"
        PostStatus.EMERGENCY -> "En emergencia"
    }
}

/**
 * Extensión para obtener el color del estado
 */
fun PostStatus.getColor(): androidx.compose.ui.graphics.Color {
    return when (this) {
        PostStatus.ADOPTED -> androidx.compose.ui.graphics.Color(0xFF4CAF50) // Verde
        PostStatus.LOST -> androidx.compose.ui.graphics.Color(0xFFF44336) // Rojo
        PostStatus.IN_ADOPTION -> androidx.compose.ui.graphics.Color(0xFF9C27B0) // Morado
        PostStatus.IN_TRANSIT -> androidx.compose.ui.graphics.Color(0xFFFF9800) // Naranja
        PostStatus.EMERGENCY -> androidx.compose.ui.graphics.Color(0xFFFF5722) // Rojo naranja
    }
}
