package com.example.myhelpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.myhelpcompose.core.theme.MyHelpComposeTheme
import com.example.myhelpcompose.presentation.components.layout.card.CardTicket
import com.example.myhelpcompose.presentation.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHelpComposeTheme {
//                NavGraph(
//                    navController = rememberNavController()
//                )
                CardTicket(
                    onIncrement = {},
                    onDecrement = {}
                )
            }
        }
    }
}