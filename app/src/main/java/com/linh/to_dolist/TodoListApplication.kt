package com.linh.to_dolist

import android.app.Application
import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.data.source.local.TodoRoomDatabase

class TodoListApplication : Application() {
    val todoRepository: TodoRepository
        get() = ServiceLocator.getTodoRepository(this)
}