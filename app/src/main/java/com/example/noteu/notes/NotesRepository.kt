package com.example.noteu.notes

import androidx.lifecycle.LiveData


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class NotesRepository(private val notesDAO: NotesDAO) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allNotes: LiveData<List<Notes>> = notesDAO.getAllNotes()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    suspend fun insert(note: Notes) {
        notesDAO.insert(note)
    }

    suspend fun delete(note: Notes) {
        notesDAO.delete(note)
    }
}