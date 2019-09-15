package com.linh.to_dolist.newtodoentry

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.linh.to_dolist.R
import com.linh.to_dolist.TodoListApplication
import com.linh.to_dolist.ViewModelFactory
import com.linh.to_dolist.databinding.ActivityNewTodoEntryBinding
import com.linh.to_dolist.util.LogTool
import java.util.*

class NewTodoEntryActivity : AppCompatActivity() {
    private var dueDate = Calendar.getInstance()

    private val viewModel by lazy {
        val repository = (applicationContext as TodoListApplication).todoRepository
        ViewModelFactory(repository).create(NewTodoEntryViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewTodoEntryBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_new_todo_entry)

        binding.viewModel = viewModel //Two-way data binding
        binding.lifecycleOwner = this

        findViewById<Button>(R.id.button_new_todo_entry_submit).setOnClickListener {
            LogTool.logD("todoentrysubmit", "Pressed button!")
            viewModel.saveTodoEntry()
            finish()
        }
    }

    fun showDatePicker(view: View) {
        val datePickerFragment = DatePickerFragment()
        datePickerFragment.show(supportFragmentManager, "datePicker")
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        viewModel.dueDate.value?.set(year, month, day)
    }
}
