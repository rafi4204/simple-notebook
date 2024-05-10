package com.example.simplenotebook.feartures.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember

@Composable
fun HomeRoute(
    homeCoordinator: HomeCoordinator
) {
    val uiState = homeCoordinator.viewModel.homeStateFlow.collectAsState().value
    val actions = rememberHomeScreenActions(homeCoordinator)
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
