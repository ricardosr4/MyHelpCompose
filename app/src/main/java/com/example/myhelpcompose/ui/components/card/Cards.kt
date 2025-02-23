package com.example.myhelpcompose.ui.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PreviewCardExamples() {
    Column {
        CardExamples()
        CustomCardItemPro(
            weekDay = "lunes",
            quantityOverHours = 5,
            percentageOverHours = 130
        ) { }

    }
}

@Composable
fun CardExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "Ejemplos de Cards con Material 3",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Card simple
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Primary Card")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // OutlinedCard simple
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            border = BorderStroke(2.dp, Color.Gray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Outlined Card")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ElevatedCard simple
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Elevated Card")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // FilledTonalCard simple
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFBB86FC)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Tonal Card", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun CustomPrimaryCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF6200EE)
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Primary Card",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CustomOutlinedCard() {
    OutlinedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(120.dp),
        border = BorderStroke(2.dp, Color(0xFF6200EE)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Outlined Card",
                fontSize = 18.sp,
                color = Color(0xFF6200EE)
            )
        }
    }
}

@Composable
fun CustomElevatedCard() {
    ElevatedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEE0000)
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Elevated Card",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CustomTonalCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF018786)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Custom Tonal Card",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CustomCardItem() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Card superior
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Horas extras  Febrero",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 22.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))

                // Mostrar las horas acumuladas por porcentaje
                Text(text = "total hrs al 130%", fontSize = 16.sp, color = Color.Black)
                Text(text = "total hrs al 100%", fontSize = 16.sp, color = Color.Black)
                Text(text = "total hrs al 75%", fontSize = 16.sp, color = Color.Black)
                Text(text = "total hrs al 50%", fontSize = 16.sp, color = Color.Black)
            }
        }
    }
}

@Composable
fun CustomCardItemPro(
    weekDay: String,
    quantityOverHours: Int,
    percentageOverHours: Int,
    onDeleteConfirm: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Confirmar eliminación") },
            text = { Text("¿Estás seguro de que deseas eliminar este ítem?") },
            confirmButton = {
                TextButton(onClick = {
                    onDeleteConfirm()
                    showDialog = false
                }) {
                    Text("Eliminar", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = weekDay,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Horas extras: $quantityOverHours",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Porcentaje: $percentageOverHours%",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            IconButton(onClick = { showDialog = true }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = Color.Red
                )
            }
        }
    }
}
