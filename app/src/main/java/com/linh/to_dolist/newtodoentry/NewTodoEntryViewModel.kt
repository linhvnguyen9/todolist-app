package com.linh.to_dolist.newtodoentry

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linh.to_dolist.data.TodoEntry
import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.util.LogTool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class NewTodoEntryViewModel(private val repository: TodoRepository) : ViewModel() {
    private val TAG = NewTodoEntryViewModel::class.java.simpleName

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun saveTodoEntry() {
        val currentTitle = title.value
        val currentDescription = description.value

        if (currentTitle == null || currentDescription == null)
            return

        createTodoEntry(
            TodoEntry(
                currentTitle,
                currentDescription,
                Calendar.getInstance()
            )
        ) //TODO: Implement calendar picker
    }

    private fun createTodoEntry(newTodoEntry: TodoEntry) = viewModelScope.launch(Dispatchers.IO) {
        LogTool.logD(TAG, "createTodoEntry: $newTodoEntry")
        repository.insert(newTodoEntry)
    }
}