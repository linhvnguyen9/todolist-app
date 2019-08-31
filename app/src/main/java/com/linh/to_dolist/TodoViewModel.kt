package com.linh.to_dolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TodoRepository
    val allTodoEntries: LiveData<List<TodoEntry>>

    init {
        val todoDao = TodoRoomDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)

        allTodoEntries = repository.allTodoEntries
    }

    fun insert(entry: TodoEntry) =
        viewModelScope.launch(Dispatchers.IO) { repository.insert(entry) }
}