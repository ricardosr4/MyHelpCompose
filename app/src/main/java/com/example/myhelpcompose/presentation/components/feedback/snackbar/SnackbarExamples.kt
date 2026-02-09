package com.example.myhelpcompose.presentation.components.feedback.snackbar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun PreviewSnackbarExamples() {
//    SnackbarExamples()

}

@Composable
fun SnackbarExamples() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Ejemplos de Snackbars en Jetpack Compose")
            Spacer(modifier = Modifier.height(16.dp))

            // Snackbar básico
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Mensaje de Snackbar básico")
                    }
                }
            ) {
                Text("Mostrar Snackbar Básico")
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Snackbar con acción
            Button(
                onClick = {
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Mensaje eliminado",
                            actionLabel = "Deshacer",
                            duration = SnackbarDuration.Long
                        )
                        if (result == SnackbarResult.ActionPerformed) {
                            // Acción de deshacer
                        }
                    }
                }
            ) {
                Text("Snackbar con Acción")
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Snackbar de error
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Error al guardar los datos",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            ) {
                Text("Snackbar de Error")
            }
            Spacer(modifier = Modifier.height(16.dp))


        }
    }
}

/**
 * ZetaSnackbar - Función helper para mostrar snackbar
 */
@Composable
fun ZetaSnackbar(
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    duration: SnackbarDuration = SnackbarDuration.Short,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val result = snackbarHostState.showSnackbar(
            message = message,
            actionLabel = actionLabel,
            duration = duration
        )
        if (result == SnackbarResult.ActionPerformed) {
            onActionClick?.invoke()
        }
    }
}

/**
 * CustomSnackbar - Snackbar personalizado con colores
 */
@Composable
fun CustomSnackbar(
    message: String,
    backgroundColor: Color = MaterialTheme.colorScheme.inverseSurface,
    contentColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Snackbar(
        modifier = modifier,
        action = {
            actionLabel?.let {
                TextButton(onClick = { onActionClick?.invoke() }) {
                    Text(it)
                }
            }
        },
        containerColor = backgroundColor,
        contentColor = contentColor
    ) {
        Text(message)
    }
}

/**
 * ErrorSnackbar - Snackbar para errores
 */
@Composable
fun ErrorSnackbar(
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    CustomSnackbar(
        message = message,
        backgroundColor = MaterialTheme.colorScheme.error,
        contentColor = MaterialTheme.colorScheme.onError,
        actionLabel = actionLabel,
        onActionClick = onActionClick,
        modifier = modifier
    )
}

/**
 * SuccessSnackbar - Snackbar para éxito
 */
@Composable
fun SuccessSnackbar(
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    CustomSnackbar(
        message = message,
        backgroundColor = Color(0xFF4CAF50),
        contentColor = Color.White,
        actionLabel = actionLabel,
        onActionClick = onActionClick,
        modifier = modifier
    )
}

/**
 * InfoSnackbar - Snackbar para información
 */
@Composable
fun InfoSnackbar(
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    CustomSnackbar(
        message = message,
        backgroundColor = Color(0xFF2196F3),
        contentColor = Color.White,
        actionLabel = actionLabel,
        onActionClick = onActionClick,
        modifier = modifier
    )
}

// Ejemplo de uso en un Scaffold
@Composable
fun SnackbarExampleScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                when {
                    data.visuals.message.contains("Error", ignoreCase = true) -> {
                        ErrorSnackbar(
                            message = data.visuals.message.toString(),
                            actionLabel = data.visuals.actionLabel,
                            onActionClick = { data.performAction() }
                        )
                    }
                    data.visuals.message.contains("éxito", ignoreCase = true) -> {
                        SuccessSnackbar(
                            message = data.visuals.message.toString(),
                            actionLabel = data.visuals.actionLabel,
                            onActionClick = { data.performAction() }
                        )
                    }
                    else -> {
                        Snackbar(snackbarData = data)
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Error al procesar")
                    }
                }
            ) {
                Text("Mostrar Error")
            }
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Operación completada con éxito")
                    }
                }
            ) {
                Text("Mostrar Éxito")
            }
        }
    }
}