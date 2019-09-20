package com.linh.to_dolist

import com.linh.to_dolist.data.source.TodoRepository
import com.linh.to_dolist.main.TodoViewModel
import com.linh.to_dolist.newtodoentry.NewTodoEntryViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<TodoRepository> { ServiceLocator.getTodoRepository(androidApplication()) }

    viewModel { TodoViewModel(get()) }
    viewModel { NewTodoEntryViewModel(get()) }
}