package com.example.nativeapplication.repository.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nativeapplication.common.NOTES_TABLE

@Entity(tableName = NOTES_TABLE)
data class NoteDBModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val text: String
)
