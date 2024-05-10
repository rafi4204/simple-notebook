package com.example.simplenotebook.feartures.home.ui

import com.example.simplenotebook.data.model.NoteItem

data class HomeState(
    val noteItemList: List<NoteItem>? = emptyList(),
    val noteItem: NoteItem? = null,
)


data class HomeActions(
    val navigateToAddNoteItemScreen: () -> Unit = {},
    val openNoteItem: (Int) -> Unit = {}
)