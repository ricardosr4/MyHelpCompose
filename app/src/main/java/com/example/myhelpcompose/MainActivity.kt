package com.example.myhelpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myhelpcompose.core.theme.MyHelpComposeTheme
import com.example.myhelpcompose.presentation.components.inputs.buttons.MyFloatingActionButton
import com.example.myhelpcompose.presentation.components.navigation.TopBars.MenuItem
import com.example.myhelpcompose.presentation.components.navigation.TopBars.TopAppBar
import com.example.myhelpcompose.presentation.components.navigation.buttonBars.BottomNavItems
import com.example.myhelpcompose.presentation.components.navigation.buttonBars.BottomNavigationBar
import com.example.myhelpcompose.presentation.components.navigation.drawers.DrawerItems
import com.example.myhelpcompose.presentation.components.navigation.drawers.NavigationDrawer
import com.example.myhelpcompose.presentation.navigation.NavGraph
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHelpComposeTheme {
                NavGraph(
                    navController = rememberNavController()
                )
            }
        }
    }
}