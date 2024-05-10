package com.example.simplenotebook.data.repository

import androidx.annotation.WorkerThread
import com.example.simplenotebook.data.dao.NoteDao
import com.example.simplenotebook.data.model.NoteItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNoteListRepository @Inject constructor(private val noteDao: NoteDao) {
    //val noteItems: Flow<List<NoteItem>> = noteDao.getAll()

    @WorkerThread
    suspend fun getNoteList(): List<NoteItem> {
        return noteDao.getAll()
    }

    @WorkerThread
    suspend fun insert(noteItem: NoteItem) {
        noteDao.insertAll(noteItem)
    }

    suspend fun getNoteById(id: Int): NoteItem {
        return noteDao.findById(id)
    }


}