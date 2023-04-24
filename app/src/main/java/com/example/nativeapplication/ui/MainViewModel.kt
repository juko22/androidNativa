package com.example.nativeapplication.ui

import androidx.lifecycle.ViewModel
import com.example.nativeapplication.repository.AppRepository
import com.example.nativeapplication.ui.notesFragment.models.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private val repository: AppRepository) : ViewModel() {

    val getNotes = repository.getNotes

    fun addNote(title: String, text: String) = repository.addNote(title, text)

    fun deleteNote(note: NoteModel) = repository.deleteNote(note)
}