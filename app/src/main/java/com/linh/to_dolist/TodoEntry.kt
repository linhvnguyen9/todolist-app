package com.linh.to_dolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.*

@Entity(tableName = "todo_table")
data class TodoEntry(
    var title: String,
    var description: String,
    @ColumnInfo(name = "due_date") var dueDate: Calendar
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}