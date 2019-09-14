package com.linh.to_dolist.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.linh.to_dolist.ServiceLocator
import com.linh.to_dolist.data.TodoEntry
import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.data.source.local.TodoRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TodoRepository = ServiceLocator.getTodoRepository(application)
    val allTodoEntries: LiveData<List<TodoEntry>>

    init {
        allTodoEntries = repository.allTodoEntries
    }
}