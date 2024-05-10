package com.example.simplenotebook.feartures.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel

class HomeCoordinator(
    val viewModel: HomeViewModel,
    val navigateToAddNoteItemScreen: () -> Unit = {}
) {
    val uiState = viewModel.homeStateFlow
    fun navigateToAddNoteItem() = navigateToAddNoteItemScreen
}

@Composable
fun rememberHomeCoordinator(
    homeViewModel: HomeViewModel = viewModel()
): HomeCoordinator {
    return remember(homeViewModel) {
        HomeCoordinator(homeViewModel)
    }
}
