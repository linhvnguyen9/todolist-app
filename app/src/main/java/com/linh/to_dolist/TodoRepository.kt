package com.linh.to_dolist

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {
    val allTodoEntries: LiveData<List<TodoEntry>> = todoDao.getAllEntries()

    @WorkerThread
    suspend fun insert(todoEntry: TodoEntry) {
        todoDao.insert(todoEntry)
    }
}