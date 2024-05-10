package com.example.simplenotebook.feartures.home.domain

import com.example.simplenotebook.core.suspendRunCatching
import com.example.simplenotebook.data.repository.GetNoteListRepository
import javax.inject.Inject

class GetNoteListUseCase @Inject constructor(private val noteListRepository: GetNoteListRepository) {

    suspend operator fun invoke() = suspendRunCatching {
        noteListRepository.noteItems
    }
}