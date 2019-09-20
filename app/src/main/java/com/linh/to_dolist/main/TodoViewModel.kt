package com.linh.to_dolist.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.linh.to_dolist.data.TodoEntry
import com.linh.to_dolist.data.source.TodoRepository

class TodoViewModel(repository: TodoRepository) : ViewModel() {
    val allTodoEntries: LiveData<List<TodoEntry>> = repository.allTodoEntries
}