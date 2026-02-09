package com.example.myhelpcompose.presentation.components.inputs.switch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PreviewSwitchExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SwitchExamples()
        CustomSwitch()

        // SwitchWithIcon con icono
        var isChecked1 by remember { mutableStateOf(false) }
        SwitchWithIcon(
            text = "Notificaciones push",
            checked = isChecked1,
            onCheckedChange = { isChecked1 = it },
            leadingIcon = {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.Notifications,
                    contentDescription = null
                )
            }
        )

        // SwitchWithIcon sin icono
        var isChecked2 by remember { mutableStateOf(true) }
        SwitchWithIcon(
            text = "Modo silencioso",
            checked = isChecked2,
            onCheckedChange = { isChecked2 = it }
        )
    }
}

@Composable
fun SwitchExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Ejemplos de Switches en Jetpack Compose")
        Spacer(modifier = Modifier.height(16.dp))

        // Switch básico
        var isChecked by remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Activar notificaciones")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Switch con estado inicial activado
        var isEnabled by remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = isEnabled,
                onCheckedChange = { isEnabled = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Modo oscuro activado")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Switch deshabilitado
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = false,
                onCheckedChange = { },
                enabled = false
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Opción deshabilitada",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun CustomSwitch() {
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Switches Personalizados",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Switch con colores personalizados
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Switch Personalizado",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Switch con colores alternativos
        var isChecked2 by remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = isChecked2,
                onCheckedChange = { isChecked2 = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF6200EE),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Switch Alternativo",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * ZetaSwitch - Switch reutilizable básico
 */
@Composable
fun ZetaSwitch(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = MaterialTheme.colorScheme.primary
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable(enabled = enabled) { onCheckedChange(!checked) }
        )
    }
}

/**
 * SwitchWithIcon - Switch con icono
 */
@Composable
fun SwitchWithIcon(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        leadingIcon?.invoke()
        if (leadingIcon != null) {
            Spacer(modifier = Modifier.width(8.dp))
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ZetaSwitchPreview() {
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ZetaSwitch(
            text = "Activar notificaciones",
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        ZetaSwitch(
            text = "Modo oscuro",
            checked = true,
            onCheckedChange = { },
            enabled = false
        )
    }
}