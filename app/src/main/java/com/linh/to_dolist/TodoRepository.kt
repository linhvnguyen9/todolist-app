package com.linh.to_dolist

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData

class TodoRepository(private val todoDao: TodoDao) {
    val allTodoEntries: MutableLiveData<List<TodoEntry>> = todoDao.getAllEntries()

    @WorkerThread
    suspend fun insert(todoEntry: TodoEntry) {
        todoDao.insert(todoEntry)
    }
}