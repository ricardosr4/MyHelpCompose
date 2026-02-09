package com.example.myhelpcompose.presentation.components.inputs.textFields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Colores para el SearchBar de Huella
 */
private val HuellaWhite = Color.White
private val HuellaGray = Color(0xFF757575)
private val HuellaCyan = Color(0xFF13D4CA)

/**
 * Barra de búsqueda estilo Huella
 * Diseño con forma de píldora y borde inferior cyan
 *
 * @param value Texto actual del campo de búsqueda
 * @param onValueChange Callback cuando cambia el texto
 * @param onSearch Callback cuando se ejecuta la búsqueda (presionar Enter)
 * @param placeholder Texto del placeholder (por defecto "Buscar")
 * @param modifier Modifier opcional
 */
@Composable
fun HuellaSearchBar(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    onSearch: (String) -> Unit = {},
    placeholder: String = "Buscar",
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf(value) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50.dp))
            .background(HuellaWhite)
            .border(
                width = 3.dp,
                color = HuellaCyan,
                shape = RoundedCornerShape(50.dp)
            )
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono de búsqueda
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            tint = HuellaGray,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )

        // Campo de texto
        BasicTextField(
            value = searchText,
            onValueChange = { newValue ->
                searchText = newValue
                onValueChange(newValue)
            },
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.Black
            ),
            cursorBrush = SolidColor(HuellaGray),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch(searchText)
                }
            ),
            decorationBox = { innerTextField ->
                if (searchText.isEmpty()) {
                    Text(
                        text = placeholder,
                        fontSize = 16.sp,
                        color = HuellaGray
                    )
                }
                innerTextField()
            }
        )
    }
}
