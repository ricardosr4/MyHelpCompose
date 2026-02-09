package com.example.myhelpcompose.presentation.components.inputs.radiobutton

import androidx.compose.foundation.clickable
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
fun PreviewRadioButtonExamples() {
    Column {
        RadioButtonExamples()
        CustomRadioButton()

        var selected by remember { mutableStateOf<String?>(null) }

        RadioButtonGroup(
            options = listOf("Opción A", "Opción B", "Opción C"),
            selectedOption = selected,
            onOptionSelected = { selected = it },
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun RadioButtonExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Ejemplos de RadioButtons en Jetpack Compose")
        Spacer(modifier = Modifier.height(16.dp))

        // RadioButton básico
        var selectedOption by remember { mutableStateOf("") }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "opcion1",
                onClick = { selectedOption = "opcion1" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Opción 1")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "opcion2",
                onClick = { selectedOption = "opcion2" }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Opción 2")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // RadioButton con texto integrado
        var selectedGender by remember { mutableStateOf("") }
        RadioButton(
            selected = selectedGender == "masculino",
            onClick = { selectedGender = "masculino" }
        )
        Spacer(modifier = Modifier.height(8.dp))
        RadioButton(
            selected = selectedGender == "femenino",
            onClick = { selectedGender = "femenino" }
        )
    }
}

@Composable
fun CustomRadioButton() {
    var selectedOption by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "RadioButtons Personalizados",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // RadioButton con colores personalizados
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "custom1",
                onClick = { selectedOption = "custom1" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary,
                    unselectedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Opción Personalizada 1",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "custom2",
                onClick = { selectedOption = "custom2" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF6200EE),
                    unselectedColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Opción Personalizada 2",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * ZetaRadioButton - RadioButton reutilizable básico
 */
@Composable
fun ZetaRadioButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable(enabled = enabled) { onClick() }
        )
    }
}


/**
 * RadioButtonGroup - Grupo de RadioButtons con opciones
 */
@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        options.forEach { option ->
            ZetaRadioButton(
                text = option,
                selected = selectedOption == option,
                onClick = { onOptionSelected(option) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun RadioButtonGroupPreview() {
    var selected by remember { mutableStateOf<String?>(null) }

    RadioButtonGroup(
        options = listOf("Opción A", "Opción B", "Opción C"),
        selectedOption = selected,
        onOptionSelected = { selected = it }
    )
}
