package com.example.simplenotebook

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplenotebook.feartures.addnoteitem.ui.AddNoteItemRoute
import com.example.simplenotebook.feartures.addnoteitem.ui.rememberAddNoteItemCoordinator
import com.example.simplenotebook.feartures.home.ui.HomeRoute
import com.example.simplenotebook.feartures.home.ui.rememberHomeCoordinator
import com.example.simplenotebook.ui.theme.SimpleNotebookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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
                    val homeCoordinator =
                        rememberHomeCoordinator(navigateToAddNoteItemScreen = {
                            navController.navigate(
                                 Route.ADD_NOTE_ITEM.route
                            )
                        })
                    val addNoteItemCoordinator =
                        rememberAddNoteItemCoordinator(navigateToHomeScreen = {
                            navController.navigate(Route.HOME.route)
                        })
                    NavHost(navController = navController, startDestination = Route.HOME.route) {
                        composable(Route.HOME.route) { HomeRoute(homeCoordinator) }
                        composable(Route.ADD_NOTE_ITEM.route) {
                            AddNoteItemRoute(
                                addNoteItemCoordinator
                            )
                        }
                    }
                }
            }
        }
    }
}

enum class Route(val route: String) {
    HOME("home"), ADD_NOTE_ITEM("addNoteItem")
}
