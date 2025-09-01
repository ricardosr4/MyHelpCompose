package com.example.myhelpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myhelpcompose.core.theme.MyHelpComposeTheme
import com.example.myhelpcompose.presentation.components.inputs.buttons.MyFloatingActionButton
import com.example.myhelpcompose.presentation.components.navigation.TopBars.ZetaTopAppBar
import com.example.myhelpcompose.presentation.components.navigation.buttonBars.NavigationButtonBar
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHelpComposeTheme {
                val snackBackHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { ZetaTopAppBar() },
                    snackbarHost = { SnackbarHost(hostState = snackBackHostState) },
                    floatingActionButton = { MyFloatingActionButton() },
                    floatingActionButtonPosition = FabPosition.Center,
                    bottomBar = { NavigationButtonBar() }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "pincha aqui", 
                            modifier = Modifier.clickable {
                                scope.launch {
                                    snackBackHostState.showSnackbar(
                                        message = "Eres el Mejor",
                                        actionLabel = "eliminar"
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


