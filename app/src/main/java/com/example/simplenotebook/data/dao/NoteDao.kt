package com.example.simplenotebook.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.simplenotebook.data.model.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM noteitem")
    suspend fun getAll(): List<NoteItem>

    @Query("SELECT * FROM noteitem WHERE id IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<NoteItem>

    @Query("SELECT * FROM noteitem WHERE id LIKE :id LIMIT 1")
    suspend fun findById(id: Int): NoteItem

    @Insert
    suspend fun insertAll(vararg noteItem: NoteItem)

    @Delete
    suspend fun delete(noteItem: NoteItem)
}