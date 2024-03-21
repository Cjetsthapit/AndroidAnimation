package com.sthapit.androidanimation

import EnterExitScreen
import InfiniteScreen
import ScaleScreen
import TransitionScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sthapit.androidanimation.ui.theme.AndroidAnimationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAnimationTheme {
                val navController = rememberNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = getTitleForRoute(currentRoute),
                                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                                )
                            },
                            navigationIcon = {
                                if (currentRoute != "home") {
                                    IconButton(onClick = { navController.navigateUp() }) {
                                        Icon(
                                            Icons.Filled.ArrowBack,
                                            contentDescription = "Back",
                                            tint = Color.White
                                        )
                                    }

                                }

                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeScreen(navController) }
                        composable("transition") { TransitionScreen(navController) }
                        composable("scale") { ScaleScreen(navController) }
                        composable("infinite") { InfiniteScreen(navController) }
                        composable("enterExit") { EnterExitScreen(navController) }

                    }
                }
            }
        }
    }

    private fun getTitleForRoute(route: String?): String {
        return when (route) {
            "home" -> "Home"
            "transition" -> "Transition Animation"
            "scale" -> "Scale Animation"
            "infinite" -> "Infinite Animation"
            "enterExit" -> "Enter Exit Animation"

            else -> ""
        }
    }
}


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("transition") }) {
            Text("Transition Animation")
        }
        Button(onClick = { navController.navigate("scale") }) {
            Text("Scale Animation")
        }
        Button(onClick = { navController.navigate("infinite") }) {
            Text("Infinite Animation")
        }
        Button(onClick = { navController.navigate("enterExit") }) {
            Text("Enter Exit Animation")
        }
    }
}
