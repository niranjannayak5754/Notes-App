package com.example.noteu.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myNotes")
class Notes(@ColumnInfo(name = "Tasks") val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}