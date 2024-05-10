package com.example.simplenotebook.feartures.addnoteitem.domain

import com.example.simplenotebook.core.suspendRunCatching
import com.example.simplenotebook.data.model.NoteItem
import com.example.simplenotebook.data.repository.GetNoteListRepository
import javax.inject.Inject

class InsertNoteItemsUseCase @Inject constructor(private val repository: GetNoteListRepository) {
    suspend operator fun invoke(noteItem: NoteItem) = suspendRunCatching {
        repository.insert(noteItem)
    }
}