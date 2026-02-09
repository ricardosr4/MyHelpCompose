package com.example.myhelpcompose.presentation.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Colores para el componente de imagen
 */
private val HuellaCyan = Color(0xFF13D4CA)
private val HuellaWhite = Color.White

/**
 * Componente de imagen del post
 * Muestra la imagen de la mascota con un icono flotante en la esquina superior izquierda
 *
 * @param imageUrl URL de la imagen
 * @param contentDescription Descripción para accesibilidad
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaPostImage(
    imageUrl: String,
    contentDescription: String = "Imagen de mascota",
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Mantiene proporción cuadrada
    ) {
        // Imagen principal
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        // Icono flotante en la esquina superior izquierda
        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(HuellaCyan)
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Pets,
                contentDescription = "Icono de mascota",
                tint = HuellaWhite,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}
