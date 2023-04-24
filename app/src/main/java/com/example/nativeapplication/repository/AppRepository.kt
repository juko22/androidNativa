package com.example.nativeapplication.repository

import com.example.nativeapplication.common.launchIO
import com.example.nativeapplication.repository.dao.AppDao
import com.example.nativeapplication.repository.model.NoteDBModel
import com.example.nativeapplication.ui.notesFragment.models.NoteModel
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.util.TimeZone

class AppRepository(private val appDao: AppDao) {

    val getNotes = appDao.getNotes().map { it.asNotesItemList() }

    fun addNote(title: String, text: String) {
        launchIO {
            appDao.addNote(NoteDBModel(0, title, text))
            Timber.d("Note added repo")
        }
    }

    fun deleteNote(note: NoteModel) {
        launchIO {
            appDao.deleteNote(note.asNoteDBModel())
        }
    }
}