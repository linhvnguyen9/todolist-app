package com.linh.to_dolist.data.source


import android.content.Context
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.linh.to_dolist.data.source.local.TodoDao
import com.linh.to_dolist.data.TodoEntry
import com.linh.to_dolist.data.source.local.TodoRoomDatabase
import com.linh.to_dolist.util.LogTool

class TodoRepository(private val todoDao: TodoDao) {
    private val TAG = TodoRepository::class.java.simpleName

    init {
        LogTool.logD(TAG, "instantiated")
    }

    val allTodoEntries: LiveData<List<TodoEntry>> = todoDao.getAllEntries()

    @WorkerThread
    suspend fun insert(todoEntry: TodoEntry) {
        LogTool.logD(TAG, "insert $todoEntry")
        todoDao.insert(todoEntry)
    }
}