package com.linh.to_dolist

import android.app.Application
import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.data.source.local.TodoRoomDatabase

class TodoListApplication : Application() {
    val todoRepository: TodoRepository
        get() {
            val todoDao = TodoRoomDatabase.getDatabase(this).todoDao()
            return TodoRepository(todoDao) //TODO: TodoRepository is instantiated multiple times
        }
}