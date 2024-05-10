package com.example.simplenotebook.feartures.addnoteitem.ui

import com.example.simplenotebook.data.model.NoteItem

data class AddNoteItemState(
    val noteItem: NoteItem? = null,
    val title: String = "",
    val content: String = "",
    val isNoteItemInserted: Boolean = false
)


data class AddNoteItemActions(
    val onAddNoteItem: (NoteItem) -> Unit = {},
    val onTitleChange: (String) -> Unit = {},
    val onContentChange: (String) -> Unit = {},
    val navigateToHome: () -> Unit = {}
)