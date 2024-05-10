package com.example.simplenotebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplenotebook.feartures.home.ui.HomeRoute
import com.example.simplenotebook.feartures.home.ui.rememberHomeCoordinator
import com.example.simplenotebook.ui.theme.SimpleNotebookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNotebookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val homeCoordinator = rememberHomeCoordinator()
                    NavHost(navController = navController, startDestination = Route.HOME.route) {
                        composable(Route.HOME.route) { HomeRoute(homeCoordinator) }
                        composable(Route.ADD_NOTE_ITEM.route) {  }
                    }
                }
            }
        }
    }
}

enum class Route(val route: String) {
    HOME("home"), ADD_NOTE_ITEM("addNoteItem")
}
