package com.example.myhelpcompose.presentation.components.display.text

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PreviewTextExamples() {
    Column {
        TextExamples()
        CustomHeadlineText()
        CustomBodyText()
        CustomSubtitleText()
        CustomCaptionText()
        CustomOverlineText()
    }
}

@Composable
fun TextExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            text = "Ejemplos de Texto con Material 3",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Headline1 Text
        Text(text = "Headline1 Example", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Body Text
        Text(text = "Body1 Example", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Subtitle Text
        Text(text = "Subtitle Example", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Caption Text
        Text(text = "Caption Example", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Overline Text
        Text(text = "Overline Example", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun CustomHeadlineText() {
    Text(
        text = "Custom Headline Text",
        fontSize = 30.sp, // Tamaño personalizado
        color = Color(0xFF6200EE), // Color del texto
        style = MaterialTheme.typography.headlineLarge, // Estilo de headline
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun CustomBodyText() {
    Text(
        text = "Custom Body Text",
        fontSize = 18.sp, // Tamaño del texto
        color = Color.Black, // Color del texto
        style = MaterialTheme.typography.bodyLarge, // Estilo de body
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun CustomSubtitleText() {
    Text(
        text = "Custom Subtitle Text",
        fontSize = 16.sp, // Tamaño del texto
        color = Color.Gray, // Color del texto
        style = MaterialTheme.typography.bodyMedium, // Estilo de subtitle
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun CustomCaptionText() {
    Text(
        text = "Custom Caption Text",
        fontSize = 14.sp, // Tamaño del texto
        color = Color(0xFF018786), // Color personalizado
        style = MaterialTheme.typography.displayMedium, // Estilo de caption
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun CustomOverlineText() {
    Text(
        text = "Custom Overline Text",
        fontSize = 12.sp, // Tamaño del texto
        color = Color(0xFF6200EE), // Color del texto
        style = MaterialTheme.typography.displayLarge, // Estilo de overline
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}