package com.example.myhelpcompose.presentation.components.inputs.buttons.custom

import androidx.compose.foundation.BorderStroke
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
fun PreviewButtonExamples() {
    Column {
        ButtonExamples()
        CustomPrimaryButton()
        CustomOutlinedButton()
        CustomTextButton()
        CustomElevatedButton()
        CustomFilledTonalButton()

    }
}

@Composable
fun ButtonExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            modifier = Modifier,
            text = "Botones de Ejemplo con Material 3",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón primario (Button)
        Button(onClick = { println("Primary Button Clicked") }) {
            Text(text = "Primary Button")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón secundario (OutlinedButton)
        OutlinedButton(onClick = { println("Outlined Button Clicked") }) {
            Text(text = "Outlined Button")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Botón de texto (TextButton)
        TextButton(onClick = { println("Text Button Clicked") }) {
            Text(text = "Text Button")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Botón elevado (ElevatedButton)
        ElevatedButton(onClick = { println("Elevated Button Clicked") }) {
            Text(text = "Elevated Button")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Botón tonal (TonalButton)
        FilledTonalButton(onClick = { println("Tonal Button Clicked") }) {
            Text(text = "Tonal Button")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CustomPrimaryButton() {
    Button(
        onClick = { println("Primary Button Clicked") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp), // Tamaño personalizado
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6200EE), // Color de fondo del botón
            contentColor = Color.White // Color del texto
        ),
        shape = MaterialTheme.shapes.medium, // Forma redondeada
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 6.dp, // Sombra al presionar
            pressedElevation = 8.dp // Sombra al presionar
        ),
        border = BorderStroke(2.dp, Color(0xFF3700B3)), // Borde del botón
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp) // Espaciado interno
    ) {
        Text(
            text = "Primary Button",
            fontSize = 18.sp, // Tamaño del texto
            style = MaterialTheme.typography.bodyLarge, // Estilo del texto
        )
    }
}

@Composable
fun Spacer() {
    Spacer(modifier = Modifier.height(16.dp))

}

@Composable
fun CustomOutlinedButton() { //agregar parametros para hacerlo custom
    OutlinedButton(
        onClick = { println("Outlined Button Clicked") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp), // Tamaño personalizado
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFF6200EE) // Color del texto (content)
        ),
        border = BorderStroke(2.dp, Color(0xFF6200EE)), // Borde del botón
        shape = MaterialTheme.shapes.medium, // Forma redondeada
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp) // Espaciado interno
    ) {
        Text(
            text = "Outlined Button",
            fontSize = 18.sp, // Tamaño del texto
            style = MaterialTheme.typography.bodyLarge, // Estilo del texto
        )
    }
}

@Composable
fun CustomTextButton() {
    TextButton(
        onClick = { println("Text Button Clicked") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp), // Tamaño del botón
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color(0xFF03DAC5) // Color del texto
        ),
        shape = MaterialTheme.shapes.medium, // Forma redondeada
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp) // Espaciado interno
    ) {
        Text(
            text = "Text Button",
            fontSize = 18.sp, // Tamaño del texto
            style = MaterialTheme.typography.bodyLarge, // Estilo del texto
        )
    }
}

@Composable
fun CustomElevatedButton() {
    ElevatedButton(
        onClick = { println("Elevated Button Clicked") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp), // Tamaño del botón
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(0xFFEE0000), // Fondo del botón
            contentColor = Color.White // Color del texto
        ),
        shape = MaterialTheme.shapes.medium, // Forma redondeada
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 8.dp, // Elevación estándar
            pressedElevation = 12.dp, // Elevación al presionar
            disabledElevation = 0.dp // Elevación cuando está deshabilitado
        ),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp) // Espaciado interno
    ) {
        Text(
            text = "Elevated Button",
            fontSize = 18.sp, // Tamaño del texto
            style = MaterialTheme.typography.bodyLarge, // Estilo del texto
        )
    }
}

@Composable
fun CustomFilledTonalButton() {
    FilledTonalButton(
        onClick = { println("Tonal Button Clicked") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(50.dp), // Tamaño del botón
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = Color(0xFF018786), // Fondo del botón
            contentColor = Color.White // Color del texto
        ),
        shape = MaterialTheme.shapes.medium, // Forma redondeada
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 12.dp) // Espaciado interno
    ) {
        Text(
            text = "Tonal Button",
            fontSize = 18.sp, // Tamaño del texto
            style = MaterialTheme.typography.bodyLarge, // Estilo del texto
        )
    }
}




