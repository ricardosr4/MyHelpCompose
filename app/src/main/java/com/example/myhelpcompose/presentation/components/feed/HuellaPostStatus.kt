package com.example.myhelpcompose.presentation.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Badge de estado del post (Adoptado, Perdida, etc.)
 * Muestra un chip con el estado de la publicación
 *
 * @param status Estado del post
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaPostStatus(
    status: PostStatus,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))

            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = "${status.toDisplayText()}😍",
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
