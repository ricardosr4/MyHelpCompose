package com.example.myhelpcompose.presentation.components.feedback.progressindicator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PreviewProgressIndicatorExamples() {
    Column {
        ProgressIndicatorExamples()
        CustomProgressIndicators()
    }
}

@Composable
fun ProgressIndicatorExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Ejemplos de Progress Indicators en Jetpack Compose")
        Spacer(modifier = Modifier.height(16.dp))

        // CircularProgressIndicator básico
        Text("Circular Progress Indicator")
        Spacer(modifier = Modifier.height(8.dp))
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(24.dp))

        // LinearProgressIndicator básico
        Text("Linear Progress Indicator")
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        // CircularProgressIndicator con progreso
        Text("Circular Progress (50%)")
        Spacer(modifier = Modifier.height(8.dp))
        CircularProgressIndicator(
            progress = 0.5f
        )
        Spacer(modifier = Modifier.height(24.dp))

        // LinearProgressIndicator con progreso
        Text("Linear Progress (75%)")
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = 0.75f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CustomProgressIndicators() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Progress Indicators Personalizados",
            style = MaterialTheme.typography.titleMedium
        )

        // CircularProgressIndicator personalizado
        CircularProgressIndicator(
            progress = 0.6f,
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 4.dp,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )

        // LinearProgressIndicator personalizado
        Column {
            Text("Progreso de descarga: 60%")
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = 0.6f,
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF6200EE),
                trackColor = Color.LightGray
            )
        }

        // LinearProgressIndicator sin progreso (indeterminado)
        Column {
            Text("Cargando...")
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

/**
 * ZetaCircularProgress - CircularProgressIndicator reutilizable
 */
@Composable
fun ZetaCircularProgress(
    progress: Float? = null,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    strokeWidth: Dp = 4.dp
) {
    if (progress != null) {
        CircularProgressIndicator(
            progress = progress,
            modifier = modifier,
            color = color,
            strokeWidth = strokeWidth
        )
    } else {
        CircularProgressIndicator(
            modifier = modifier,
            color = color,
            strokeWidth = strokeWidth
        )
    }
}

/**
 * ZetaLinearProgress - LinearProgressIndicator reutilizable
 */
@Composable
fun ZetaLinearProgress(
    progress: Float? = null,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant
) {
    if (progress != null) {
        LinearProgressIndicator(
            progress = progress,
            modifier = modifier,
            color = color,
            trackColor = trackColor
        )
    } else {
        LinearProgressIndicator(
            modifier = modifier,
            color = color,
            trackColor = trackColor
        )
    }
}

/**
 * ProgressWithLabel - ProgressIndicator con etiqueta de porcentaje
 */
@Composable
fun ProgressWithLabel(
    progress: Float,
    label: String? = null,
    modifier: Modifier = Modifier,
    showPercentage: Boolean = true
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label ?: "Progreso",
                style = MaterialTheme.typography.bodyMedium
            )
            if (showPercentage) {
                Text(
                    text = "${(progress * 100).toInt()}%",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        ZetaLinearProgress(progress = progress)
    }
}

/**
 * LoadingState - Estado de carga completo con mensaje
 */
@Composable
fun LoadingState(
    message: String = "Cargando...",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ZetaCircularProgress()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProgressWithLabelPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProgressWithLabel(
            progress = 0.45f,
            label = "Descarga"
        )
        ProgressWithLabel(
            progress = 0.75f,
            label = "Subida",
            showPercentage = true
        )
    }
}