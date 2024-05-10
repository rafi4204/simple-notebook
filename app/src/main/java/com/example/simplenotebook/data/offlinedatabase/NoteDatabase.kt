package com.example.simplenotebook.data.offlinedatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplenotebook.data.dao.NoteDao
import com.example.simplenotebook.data.model.NoteItem

@Database(entities = [NoteItem::class], version = 2)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
