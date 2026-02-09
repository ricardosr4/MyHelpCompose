package com.example.myhelpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.myhelpcompose.core.theme.MyHelpComposeTheme
import com.example.myhelpcompose.presentation.components.feedback.progressindicator.ProgressIndicatorExamples
import com.example.myhelpcompose.presentation.components.feedback.snackbar.CustomSnackbar
import com.example.myhelpcompose.presentation.components.feedback.snackbar.SnackbarExamples
import com.example.myhelpcompose.presentation.components.inputs.pickers.DatePickerBasic
import com.example.myhelpcompose.presentation.components.layout.card.CardTicket
import com.example.myhelpcompose.presentation.home.screen.HuellaScreen
import com.example.myhelpcompose.presentation.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgressIndicatorExamples()

            

        }
    }
}


