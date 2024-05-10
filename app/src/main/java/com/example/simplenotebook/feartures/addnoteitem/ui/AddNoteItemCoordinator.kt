package com.example.simplenotebook.feartures.addnoteitem.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel

class AddNoteItemCoordinator(
    val viewModel: AddNoteItemViewModel,
    val navigateToHomeScreen: () -> Unit = {}
) {
    val uiState = viewModel.stateFlow
}

@Composable
fun rememberAddNoteItemCoordinator(
    viewModel: AddNoteItemViewModel = viewModel(),
    navigateToHomeScreen: () -> Unit
): AddNoteItemCoordinator {
    return remember(viewModel) {
        AddNoteItemCoordinator(
            viewModel = viewModel,
            navigateToHomeScreen = navigateToHomeScreen
        )
    }
}