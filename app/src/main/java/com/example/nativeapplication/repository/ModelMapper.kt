package com.example.nativeapplication.repository

import com.example.nativeapplication.repository.model.NoteDBModel
import com.example.nativeapplication.ui.notesFragment.models.NoteModel

fun NoteModel.asNoteDBModel() = NoteDBModel(
    id = id,
    title = title,
    text = text
)

fun NoteDBModel.asNoteModel() = NoteModel(
    id = id,
    title = title,
    text = text
)

fun List<NoteDBModel>.asNotesItemList() = map {
    it.asNoteModel()
}
