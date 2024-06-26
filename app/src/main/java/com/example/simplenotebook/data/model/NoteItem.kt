package com.example.simplenotebook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteItem(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "data")
    val date: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String
)