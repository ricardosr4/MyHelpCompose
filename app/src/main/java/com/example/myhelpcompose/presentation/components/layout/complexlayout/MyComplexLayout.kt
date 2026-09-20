package com.example.myhelpcompose.presentation.components.layout.complexlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/*
 este es un componente que mescla los distintos tipos de layout para aprender a
 posicionar los distintos componentes y sus layout
 */

@Composable
fun MyComplexLayout(modifier: Modifier) {

    Column(modifier = Modifier) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Red)
                .fillMaxWidth()
        ) { }
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Blue)
                .fillMaxWidth()
        ) {

            Row() {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(125.dp)
                        .background(Color.Gray)
                ) { }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(185.dp)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Hola")
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Yellow)
                .fillMaxWidth()
        ) { }
    }
}

//este ejercicio se hizo del curso de aristidev
@Composable
fun Ejercicio1(modifier: Modifier) {
    Column(modifier .fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text("Ejemplo 1")
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Row() {
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Red),
                    contentAlignment = Alignment.Center) {
                    Text("Ejemplo 2")
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Green),
                    contentAlignment = Alignment.Center) {
                    Text("Ejemplo 3")
                }
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text("Ejemplo 4")
        }
    }
}
