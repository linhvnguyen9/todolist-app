package com.linh.to_dolist.data.source

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.linh.to_dolist.data.source.local.TodoDao
import com.linh.to_dolist.data.TodoEntry

class TodoRepository(private val todoDao: TodoDao) {
    val allTodoEntries: LiveData<List<TodoEntry>> = todoDao.getAllEntries()

    @WorkerThread
    suspend fun insert(todoEntry: TodoEntry) {
        todoDao.insert(todoEntry)
    }
}