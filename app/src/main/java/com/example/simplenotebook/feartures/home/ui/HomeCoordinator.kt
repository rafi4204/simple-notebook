package com.example.simplenotebook.feartures.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel

class HomeCoordinator(
    val viewModel: HomeViewModel,
    val navigateToAddNoteItemScreen: () -> Unit = {}
) {
    val uiState = viewModel.stateFlow
}

@Composable
fun rememberHomeCoordinator(
    homeViewModel: HomeViewModel = viewModel(),
    navigateToAddNoteItemScreen: () -> Unit
): HomeCoordinator {
    return remember(homeViewModel) {
        HomeCoordinator(homeViewModel, navigateToAddNoteItemScreen)
    }
}
