package com.example.noteu.notes
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NotesDAO {
    @Insert(onConflict =OnConflictStrategy.IGNORE)
   suspend fun insert(note: Notes)

    @Delete
   suspend fun delete(note: Notes)

    @Query("Select * from My_Notes order by id ASC")
    fun getAllNotes(): LiveData<List<Notes>>
}