package com.example.myhelpcompose.presentation.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Card completa de un post del feed de Huella
 * Componente principal que orquesta todos los sub-componentes
 *
 * @param post Datos del post
 * @param onLikeClick Callback cuando se hace click en like
 * @param onCommentClick Callback cuando se hace click en comentar
 * @param onShareClick Callback cuando se hace click en compartir
 * @param onSaveClick Callback cuando se hace click en guardar
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaPostCard(
    post: HuellaPost,
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onSaveClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp), // Sin bordes redondeados para el feed
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            // Imagen de la mascota
            HuellaPostImage(
                imageUrl = post.imageUrl,
                contentDescription = "Imagen de ${post.description.take(20)}"
            )

            // Acciones (like, comment, share, save) + badge de estado
            HuellaPostActions(
                likes = post.likes,
                comments = post.comments,
                isLiked = post.isLiked,
                isSaved = post.isSaved,
                status = post.status,
                onLikeClick = onLikeClick,
                onCommentClick = onCommentClick,
                onShareClick = onShareClick,
                onSaveClick = onSaveClick
            )

            // Descripción y timestamp
            HuellaPostContent(
                description = post.description,
                timestamp = post.timestamp
            )

            // Espaciado inferior
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
