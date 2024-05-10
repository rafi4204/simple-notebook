package com.example.simplenotebook.feartures.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember

@Composable
fun HomeRoute(
    homeCoordinator: HomeCoordinator
) {
    val uiState = homeCoordinator.uiState.collectAsState().value
    val actions = rememberHomeScreenActions(homeCoordinator)
    LaunchedEffect(Unit) {
        homeCoordinator.viewModel.getAllNotes()
    }
    HomeScreen(
        homeState = uiState,
        actions = actions
    )
}


@Composable
fun rememberHomeScreenActions(coordinator: HomeCoordinator): HomeActions {
    return remember(coordinator) {
        HomeActions(
            navigateToAddNoteItemScreen = coordinator.navigateToAddNoteItemScreen,
            openNoteItem = coordinator.viewModel::getNoteItemById
        )
    }
}
