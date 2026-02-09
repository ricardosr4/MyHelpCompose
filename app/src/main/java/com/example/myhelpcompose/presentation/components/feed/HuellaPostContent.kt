package com.example.myhelpcompose.presentation.components.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Colores para el contenido del post
 */
private val HuellaTextPrimary = Color(0xFF212121)
private val HuellaTextSecondary = Color(0xFF757575)

/**
 * Componente de contenido del post
 * Muestra la descripción y el timestamp de la publicación
 *
 * @param description Descripción del post
 * @param timestamp Tiempo transcurrido desde la publicación
 * @param maxLines Número máximo de líneas para la descripción
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaPostContent(
    description: String,
    timestamp: String,
    maxLines: Int = 3,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        // Descripción
        Text(
            text = description,
            fontSize = 14.sp,
            color = HuellaTextPrimary,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Timestamp
        Text(
            text = timestamp,
            fontSize = 12.sp,
            color = HuellaTextSecondary
        )
    }
}
