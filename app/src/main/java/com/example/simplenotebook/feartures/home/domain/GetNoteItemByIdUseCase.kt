package com.example.simplenotebook.feartures.home.domain

import com.example.simplenotebook.core.suspendRunCatching
import com.example.simplenotebook.data.repository.GetNoteListRepository
import javax.inject.Inject

class GetNoteItemByIdUseCase @Inject constructor(
    private val getNoteListRepository: GetNoteListRepository
) {
    suspend operator fun invoke(id: Int) =
        suspendRunCatching { getNoteListRepository.getNoteById(id) }
}