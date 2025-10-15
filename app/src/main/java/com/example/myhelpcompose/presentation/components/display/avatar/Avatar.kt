package com.example.myhelpcompose.presentation.components.display.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Avatar circular simple
 */
@Composable
fun Avatar(
    initials: String,
    size: Int = 48,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials.uppercase().take(2),
            color = textColor,
            fontSize = (size * 0.4).sp,
            fontWeight = FontWeight.Medium
        )
    }
}

/**
 * Avatar cuadrado con esquinas redondeadas
 */
@Composable
fun RoundedAvatar(
    initials: String,
    size: Int = 48,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials.uppercase().take(2),
            color = textColor,
            fontSize = (size * 0.4).sp,
            fontWeight = FontWeight.Medium
        )
    }
}

/**
 * Avatar con borde
 */
@Composable
fun BorderedAvatar(
    initials: String,
    size: Int = 48,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    borderColor: Color = MaterialTheme.colorScheme.outline,
    borderWidth: Int = 2
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .border(borderWidth.dp, borderColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials.uppercase().take(2),
            color = textColor,
            fontSize = (size * 0.4).sp,
            fontWeight = FontWeight.Medium
        )
    }
}

// ===== PREVIEWS =====

@Preview(showBackground = true )
@Composable
fun AvatarPreview() {
    BorderedAvatar(initials = "JD", size = 64)
}

//@Preview(name = "Avatar Cuadrado", showBackground = true)
//@Composable
//fun RoundedAvatarPreview() {
//    RoundedAvatar(initials = "AB", size = 64)
//}
//
//@Preview(name = "Avatar con Borde", showBackground = true)
//@Composable
//fun BorderedAvatarPreview() {
//    BorderedAvatar(initials = "CD", size = 64)
//}

//@Preview(name = "Todos los Avatares", showBackground = true)
//@Composable
//fun AllAvatarsPreview() {
//    androidx.compose.foundation.layout.Column(
//        modifier = androidx.compose.foundation.layout.padding(16.dp),
//        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
//    ) {
//        Avatar(initials = "JD", size = 48)
//        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.foundation.layout.height(16.dp))
//        RoundedAvatar(initials = "AB", size = 48)
//        androidx.compose.foundation.layout.Spacer(modifier = androidx.compose.foundation.layout.height(16.dp))
//        BorderedAvatar(initials = "CD", size = 48)
//    }
//}
