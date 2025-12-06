package com.example.myhelpcompose.presentation.components.inputs.textFields

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CodeSlot(
    char: Char,
    isFocused: Boolean,
    onCharChange: (Char) -> Unit,
    onDelete: () -> Unit,
    onClick: () -> Unit,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier
) {
    val displayChar = if (char == ' ') "" else char.toString()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(50.dp)
            .width(40.dp)
            .clickable(onClick = onClick)
    ) {
        BasicTextField(
            value = TextFieldValue(
                text = displayChar,
                selection = TextRange(displayChar.length)
            ),
            onValueChange = { newValue ->
                val inputText = newValue.text.filter { it.isLetterOrDigit() }.uppercase()
                if (inputText.isNotEmpty()) {
                    val newChar = inputText.last()
                    onCharChange(newChar)
                } else {
                    onDelete()
                }
            },
            modifier = Modifier
                .focusRequester(focusRequester)
                .size(width = 40.dp, height = 40.dp),
            textStyle = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            cursorBrush = SolidColor(Color.Transparent),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.size(width = 40.dp, height = 40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = displayChar.ifEmpty { "" },
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    )
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(2.dp)
                .background(
                    when {
                        isFocused -> Color.Magenta
                        char != ' ' -> Color.Black
                        else -> Color.LightGray
                    }
                )
        )
    }
}