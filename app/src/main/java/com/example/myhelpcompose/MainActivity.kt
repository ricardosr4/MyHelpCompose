package com.example.myhelpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myhelpcompose.ui.components.buttons.ButtonExamples
import com.example.myhelpcompose.ui.components.checkBox.PreviewCheckBoxExamples
import com.example.myhelpcompose.ui.components.textfields.PreviewTextFieldExamples
import com.example.myhelpcompose.ui.theme.MyHelpComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHelpComposeTheme {
                PreviewCheckBoxExamples()
            }
        }
    }
}


