package com.linh.to_dolist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert
    suspend fun insert(entry: TodoEntry)

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllEntries(): LiveData<List<TodoEntry>>
}