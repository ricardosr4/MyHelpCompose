package com.example.myhelpcompose.ui.components.checkBox

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PreviewCheckBoxExamples() {
    Column {
        CheckBoxExamples()
        CustomCheckBox()
    }
}

@Composable
fun CheckBoxExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Ejemplos de Checkboxes en Jetpack Compose")
        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox básico
        var isChecked by remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox con texto
        var isCheckedWithText by remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isCheckedWithText,
                onCheckedChange = { isCheckedWithText = it }
            )
            Text(text = "Aceptar términos y condiciones")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox con estado inverso
        var isCheckedInverted by remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isCheckedInverted,
                onCheckedChange = { isCheckedInverted = it }
            )
            Text(text = "Recibir notificaciones")
        }
    }
}

@Composable
fun CustomCheckBox() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                checkmarkColor = Color.Red
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Recibir notificaciones",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}