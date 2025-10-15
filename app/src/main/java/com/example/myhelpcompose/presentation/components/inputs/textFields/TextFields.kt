package com.example.myhelpcompose.ui.components.textfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhelpcompose.presentation.components.layout.space.ZetaSpacerVertical

@Preview(showBackground = true)
@Composable
fun PreviewTextFieldExamples() {
    Column {
        TextFieldExamples()
        CustomTextField()
        CustomOutlinedTextField()
        CustomPasswordTextField()
        CustomMultilineTextField()
        ZetaTextFieldLogin(
            value = "",
            onValueChange = {},
            label = "Nombre",
            keyboardType = KeyboardType.Text,
            isPassword = false,
            isPasswordVisible = false,
            onVisibilityToggle = null,
            leadingIcon = null,
            )
        ZetaSpacerVertical()
    }
}

@Composable
fun TextFieldExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            text = "TextFields de Ejemplo con Material 3",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // TextField básico
        var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("TextField") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // OutlinedTextField
        var outlinedTextFieldValue by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = outlinedTextFieldValue,
            onValueChange = { outlinedTextFieldValue = it },
            label = { Text("Outlined TextField") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        var passwordTextFieldValue by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = passwordTextFieldValue,
            onValueChange = { passwordTextFieldValue = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Multiline TextField
        var multilineTextFieldValue by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = multilineTextFieldValue,
            onValueChange = { multilineTextFieldValue = it },
            label = { Text("Multiline TextField") },
            maxLines = 3
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CustomTextField() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        label = { Text("Custom TextField") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(56.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Gray,
            focusedIndicatorColor = Color(0xFF6200EE),
            unfocusedIndicatorColor = Color.Gray,
            focusedLabelColor = Color(0xFF6200EE),
            unfocusedLabelColor = Color.Gray
        ),
        shape = MaterialTheme.shapes.medium,
        textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
    )
}

@Composable
fun CustomOutlinedTextField() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        label = { Text("Custom Outlined TextField") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(56.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF6200EE),
            unfocusedBorderColor = Color.Gray,
            focusedLabelColor = Color(0xFF6200EE),
            unfocusedLabelColor = Color.Gray,
            disabledBorderColor = Color.Gray
        ),
        shape = MaterialTheme.shapes.medium,
        textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Leading Icon",
                tint = Color.Gray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Trailing Icon",
                tint = Color.Gray
            )
        }
    )
}

@Composable
fun CustomPasswordTextField() {
    var passwordTextFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = passwordTextFieldValue,
        onValueChange = { passwordTextFieldValue = it },
        label = { Text("Custom Password TextField") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(56.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Gray,
            focusedIndicatorColor = Color(0xFF6200EE),
            unfocusedIndicatorColor = Color.Gray
        ),
        shape = MaterialTheme.shapes.medium,
        textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
    )
}

@Composable
fun CustomMultilineTextField() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        label = { Text("Custom Multiline TextField") },
        maxLines = 5,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF6200EE),
            unfocusedBorderColor = Color.Gray,
            focusedLabelColor = Color(0xFF6200EE),
            unfocusedLabelColor = Color.Gray,
            disabledBorderColor = Color.Gray
        ),
        shape = MaterialTheme.shapes.medium,
        textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Leading Icon",
                tint = Color.Gray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Trailing Icon",
                tint = Color.Gray
            )
        }
    )
}

@Composable
fun ZetaTextFieldLogin(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityToggle: (() -> Unit)? = null,
    leadingIcon: Painter? = null,
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.Gray) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        visualTransformation = if (isPassword && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        leadingIcon = {
            leadingIcon?.let {
                Icon(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(20.dp)
                )
            }
        },
        trailingIcon = {
            if (isPassword && onVisibilityToggle != null) {
                IconButton(onClick = onVisibilityToggle) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = if (isPasswordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                    )
                }
            }
        },
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = Color.Blue,
//            unfocusedBorderColor = Color.Gray,
//        )
    )
}
