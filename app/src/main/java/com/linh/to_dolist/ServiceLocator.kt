package com.linh.to_dolist

import android.content.Context
import android.util.Log
import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.data.source.local.TodoRoomDatabase
import com.linh.to_dolist.util.LogTool

object ServiceLocator {
    private val TAG = ServiceLocator::class.java.simpleName

    var todoRepository: TodoRepository? = null

    fun getTodoRepository(context: Context): TodoRepository {
        LogTool.logD(TAG, "getTodoRepo: TodoRepo $todoRepository")
        synchronized(this) {
            if (todoRepository == null) {
                todoRepository = createTodoRepository(context)
            }
            return todoRepository!!
        }
    }

    private fun createTodoRepository(context: Context): TodoRepository {
        val todoDao = TodoRoomDatabase.getDatabase(context).todoDao()
        return TodoRepository(todoDao)
    }
}