package com.example.noteu

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteu.notes.Notes
import com.example.noteu.notes.NotesViewModel
import com.example.noteu.recyclerView.INotesRVAdapter
import com.example.noteu.recyclerView.NotesRVAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAllNotes.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this, this)
        rvAllNotes.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NotesViewModel::class.java]
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                adapter.updateNotes(it)
            }
        })
    }
    override fun onItemClicked(note: Notes) {
        viewModel.deleteNote(note)
    }

    fun addNote(view: View) {
        val newNote = etNote.text.toString()
        if(newNote.isNotEmpty())
            viewModel.insertNote(Notes(newNote))
        etNote.setText("")
    }
}