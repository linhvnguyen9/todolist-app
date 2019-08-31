package com.linh.to_dolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo_table")
data class TodoEntry(
    @PrimaryKey(autoGenerate = true) val id: Int, var title: String,
    var description: String,
    @ColumnInfo(name = "due_date") var dueDate: Calendar
)