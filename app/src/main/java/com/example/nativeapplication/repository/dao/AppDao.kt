package com.example.nativeapplication.repository.dao

import androidx.room.*
import com.example.nativeapplication.repository.model.NoteDBModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: NoteDBModel)

    @Query("SELECT * FROM notes_table")
    fun getNotes(): Flow<List<NoteDBModel>>

    @Delete
    fun deleteNote(note: NoteDBModel)

}