package com.example.noteu.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NotesViewModel(application: Application): AndroidViewModel(application){
    val allNotes : LiveData<List<Notes>>

    init {
        val dao = NotesDatabase.getDatabase(application).notesDAO()
        val repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }

}

