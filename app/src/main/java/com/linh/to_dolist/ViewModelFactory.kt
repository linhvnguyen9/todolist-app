package com.linh.to_dolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.main.TodoViewModel
import com.linh.to_dolist.newtodoentry.NewTodoEntryViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val todoRepository: TodoRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(NewTodoEntryViewModel::class.java) -> NewTodoEntryViewModel(todoRepository)
                isAssignableFrom(TodoViewModel::class.java) -> TodoViewModel(todoRepository)
                else -> throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
            }
        } as T
}