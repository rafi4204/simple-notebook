package com.example.simplenotebook.feartures.addnoteitem.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddNoteItemRoute(coordinator: AddNoteItemCoordinator) {
    val uiState = coordinator.uiState.collectAsState().value
    val actions = rememberAddNoteItemActions(coordinator)
    if (uiState.isNoteItemInserted) {
        actions.navigateToHome.invoke()
    }
    AddNoteItemScreen(
        uiState = uiState,
        actions = actions
    )
}

@Composable
fun rememberAddNoteItemActions(coordinator: AddNoteItemCoordinator): AddNoteItemActions {
    return remember(coordinator) {
        AddNoteItemActions(
            onAddNoteItem = coordinator.viewModel::insert,
            onTitleChange = coordinator.viewModel::onTitleChanged,
            onContentChange = coordinator.viewModel::onContentChanged,
            navigateToHome = coordinator.navigateToHomeScreen
        )
    }
}