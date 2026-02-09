package com.example.myhelpcompose.presentation.components.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Colores para las acciones del post
 */
private val HuellaGray = Color(0xFF757575)
private val HuellaRed = Color(0xFFE91E63)

/**
 * Componente de acciones del post (like, comment, share, save) + badge de estado
 * Muestra los iconos de interacción estilo redes sociales y el badge de estado en la misma línea
 *
 * @param likes Número de likes
 * @param comments Número de comentarios
 * @param isLiked Si el post tiene like del usuario
 * @param isSaved Si el post está guardado
 * @param status Estado del post (opcional)
 * @param onLikeClick Callback cuando se hace click en like
 * @param onCommentClick Callback cuando se hace click en comentar
 * @param onShareClick Callback cuando se hace click en compartir
 * @param onSaveClick Callback cuando se hace click en guardar
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaPostActions(
    likes: Int,
    comments: Int,
    isLiked: Boolean = false,
    isSaved: Boolean = false,
    status: PostStatus? = null,
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onSaveClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Lado izquierdo: Like, Comment, Share, Bookmark
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Like
            ActionButton(
                icon = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                count = likes,
                tint = if (isLiked) HuellaRed else HuellaGray,
                onClick = onLikeClick
            )

            // Comment
            ActionButton(
                icon = Icons.Outlined.ChatBubbleOutline,
                count = comments,
                tint = HuellaGray,
                onClick = onCommentClick
            )
            
            // Bookmark
            ActionButton(
                icon = if (isSaved) Icons.Filled.Bookmark else Icons.Outlined.Bookmark,
                count = null,
                tint = HuellaGray,
                onClick = onSaveClick
            )

            // Share
            ActionButton(
                icon = Icons.Outlined.Send,
                count = null,
                tint = HuellaGray,
                onClick = onShareClick
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        // Lado derecho: Badge de estado
        status?.let {
            HuellaPostStatus(status = it)
        }
    }
}

/**
 * Botón de acción individual con icono y contador opcional
 */
@Composable
private fun ActionButton(
    icon: ImageVector,
    count: Int?,
    tint: Color,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )

        if (count != null && count > 0) {
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = count.toString(),
                fontSize = 14.sp,
                color = HuellaGray
            )
        }
    }
}
