package com.linh.to_dolist.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linh.to_dolist.ServiceLocator
import com.linh.to_dolist.data.TodoEntry
import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.data.source.local.TodoRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(repository: TodoRepository) : ViewModel() {
    val allTodoEntries: LiveData<List<TodoEntry>> = repository.allTodoEntries
}