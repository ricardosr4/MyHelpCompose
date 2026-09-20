package com.example.myhelpcompose.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val AppFontFamily = FontFamily.Default

internal val Typography = Typography(
    // ==========================================
    // 🌟 DISPLAY: Textos gigantes y expresivos
    // Uso: Pantallas de bienvenida (Splash), números gigantes (ej. saldo de una cuenta), o contadores.
    // Casi no se usan para leer, sino para impactar visualmente.
    // ==========================================

    // El texto más grande de toda la app.
    displayLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    // Texto gigante de tamaño medio.
    displayMedium = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    // Texto gigante de tamaño pequeño.
    displaySmall = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
    ),
    // ==========================================
    // 🌟 HEADLINE: Titulares principales
    // Uso: El título principal de una pantalla o encabezados de artículos.
    // Sirven para marcar el inicio de una sección muy importante.
    // ==========================================

    // Título principal de una pantalla completa.
    headlineLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    // Título de una sección grande.
    headlineMedium = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    // Título para sub-secciones importantes.
    headlineSmall = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    // ==========================================
    // 🌟 TITLE: Títulos de componentes (Subtítulos)
    // Uso: Títulos en la barra superior (TopAppBar), títulos de tarjetas (Cards), o cuadros de diálogo.
    // ==========================================

    // Título de TopAppBar o de un Pop-up (Diálogo) importante.
    titleLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    // Título del contenido de una tarjeta (Card) o el nombre de un ítem en una lista.
    titleMedium = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    // Subtítulo pequeño dentro de una tarjeta o lista.
    titleSmall = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    // ==========================================
    // 🌟 BODY: Cuerpos de texto (Texto de lectura)
    // Uso: Párrafos, descripciones de productos, mensajes, artículos largos.
    // Es la tipografía que tus usuarios van a leer más.
    // ==========================================

    // Párrafo estándar. Úsalo para bloques de texto normales.
    bodyLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    // Párrafo un poco más pequeño, ideal para descripciones secundarias.
    bodyMedium = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    // Texto de lectura muy pequeño. Úsalo para notas al pie o aclaraciones ("letra chica").
    bodySmall = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    // ==========================================
    // 🌟 LABEL: Etiquetas y componentes de acción
    // Uso: Botones, etiquetas en campos de texto, menús de navegación inferior.
    // Son textos cortos y funcionales que le dicen al usuario qué hacer.
    // ==========================================

    // Texto principal de los BOTONES (Button, OutlinedButton, TextButton).
    labelLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    // Texto de etiquetas pequeñas, chips (filtros) o tooltips (mensajes de ayuda).
    labelMedium = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    // El texto más pequeño de la app. Uso: Iconos del menú de navegación inferior (BottomNavigation) o contadores de caracteres.
    labelSmall = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)
