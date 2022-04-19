package com.example.noteu.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteu.R
import com.example.noteu.notes.Notes

class NotesRVAdapter(private val context: Context, private val listener : INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NotesViewHolder>() {

    private val allNotes = ArrayList<Notes>()

    inner class NotesViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val note: TextView = itemView.findViewById(R.id.tvNote)
        val delBtn: ImageView = itemView.findViewById(R.id.ivDelBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.delBtn.setOnClickListener(){
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.note.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateNotes(newList: List<Notes>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface INotesRVAdapter{
    fun onItemClicked(note:Notes)
}