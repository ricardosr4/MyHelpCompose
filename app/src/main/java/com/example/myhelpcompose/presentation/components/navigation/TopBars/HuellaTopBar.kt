package com.example.myhelpcompose.presentation.components.navigation.TopBars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Colores de Huella para el TopBar
 */
private val HuellaCyan = Color(0xFF13D4CA)
private val HuellaYellow = Color(0xFFFFC107)
private val HuellaBackground = Color(0xFFF5F5F5)

/**
 * Top Bar de Huella con el título y el icono de notificaciones
 * 
 * @param onNotificationClick Callback cuando se hace click en el icono de notificaciones
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaTopBar(
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit = {},

) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(HuellaBackground)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Texto "Huella" en cyan
        Text(
            text = "Huella",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = HuellaCyan,
            letterSpacing = 0.5.sp
        )
        
        // Icono de notificaciones en amarillo
        val interactionSource = remember { MutableInteractionSource() }
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Notificaciones",
            tint = HuellaYellow,
            modifier = Modifier
                .size(28.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onNotificationClick
                )
        )
    }
}
