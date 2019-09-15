package com.linh.to_dolist.newtodoentry

import androidx.lifecycle.LiveData
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
    private val _dueDate = MutableLiveData<Calendar>().apply { value = Calendar.getInstance() }
    val dueDate: LiveData<Calendar> = _dueDate

    fun saveTodoEntry() {
        val currentTitle = title.value
        val currentDescription = description.value

        if (currentTitle == null || currentDescription == null)
            return

        createTodoEntry(
            TodoEntry(
                currentTitle,
                currentDescription,
                dueDate.value!!
            )
        )
    }

    private fun createTodoEntry(newTodoEntry: TodoEntry) = viewModelScope.launch(Dispatchers.IO) {
        LogTool.logD(TAG, "createTodoEntry: $newTodoEntry")
        repository.insert(newTodoEntry)
    }
}