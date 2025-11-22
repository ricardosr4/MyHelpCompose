package com.example.myhelpcompose.presentation.components.layout.card


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.myhelpcompose.R


@Composable
fun CardTicket(
    modifier: Modifier = Modifier,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Column (modifier = Modifier.fillMaxSize().padding(50.dp))
    {
        Card(
            modifier = modifier
                .width(250.dp)
                .height(300.dp),
            shape = RoundedCornerShape(16.dp), //border = BorderStroke(1.dp, Color.Gray),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_example_card),
                    contentDescription = "image",
                    modifier = Modifier
                        .height(150.dp)
                        .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                        .fillMaxWidth(), contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Titulo",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Me frustra (y sé que a muchos también) ver la desconexión: te piden experiencia para conseguir trabajo, pero ¿cómo vas a conseguir esa experiencia si nadie te da la oportunidad? Cientos de currículums enviados, horas de estudio, certificaciones... y el silencio es la única respuesta. Es fácil sentirse desanimado, pensar que tal vez no eres lo suficientemente bueno o que simplemente no hay espacio para ti.\n" +
                            "Recuerdo las mañanas de práctica, las noches de debugging y la sensación de que mi esfuerzo no se traducía en resultados laborales. Pero justo ahí es donde el juego cambia.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    lineHeight = 22.sp,
                    letterSpacing = 0.05.em,
                    overflow = TextOverflow.Ellipsis, //agrega los puntitos al final del texto
                    maxLines = 2
                )

                Spacer(modifier = Modifier.weight(1f))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$5990",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Row(
                        modifier = Modifier.width(120.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        IconButton(
                            onClick = onDecrement,
                            enabled = true
                        ) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Quitar",
                                tint = MaterialTheme.colorScheme.primary ,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Text(
                            text = "0",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        IconButton(
                            onClick = onIncrement,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Agregar",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun TicketPreview() {
    CardTicket(
        onIncrement = {},
        onDecrement = {}
    )

}