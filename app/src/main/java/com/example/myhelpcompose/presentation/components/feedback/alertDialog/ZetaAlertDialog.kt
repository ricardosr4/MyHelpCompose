package com.example.myhelpcompose.presentation.components.feedback.alertDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PreviewZetaAlertDialog() {
    Box(modifier = Modifier
        .fillMaxSize()) {

    }
    ZetaAlertDialogWithCancel (
        title = "Cerrar Sesión",
        message = "Estas seguro que quieres cerrar sesión?",
        confirmText = "Confirmar",
        cancelText = "Cancelar",
        onConfirmClick = { },
        onDismissClick = { }

    )
}


@Composable
fun ZetaAlertDialog(
    title: String,
    message: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    val scroll = rememberScrollState(0)

    AlertDialog(
        onDismissRequest = { onDismissClick() },
        title = { Text(text = title) },
        text = {
            Text(
                text = message,
                textAlign = TextAlign.Justify,
                modifier = Modifier.verticalScroll(scroll)
            )
        },
        confirmButton = {
            Button(onClick = { onConfirmClick() }) {
                Text(text = confirmText)
            }
        }
    )
}

@Composable
fun ZetaAlertDialogWithCancel(
    title: String,
    message: String,
    confirmText: String,
    cancelText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    val scroll = rememberScrollState(0)

    AlertDialog(
        onDismissRequest = { onDismissClick() },
        title = {
            Text(modifier = Modifier.fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center,) },
        text = {
            Text(
                text = message,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scroll)
            )
            Spacer(modifier = Modifier.height(50.dp))
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { onDismissClick() }) {
                    Text(text = cancelText)
                }

                Button(onClick = { onConfirmClick() }) {
                    Text(text = confirmText)
                }
            }
        }
    )

}