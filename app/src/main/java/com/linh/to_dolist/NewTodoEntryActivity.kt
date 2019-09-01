package com.linh.to_dolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_new_todo_entry.*
import java.util.*

class NewTodoEntryActivity : AppCompatActivity() {

    private var dueDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo_entry)
    }

    fun onSubmitClickListener(view: View) {
        val replyIntent = Intent()

        if (TextUtils.isEmpty(edittext_new_todo_entry_title.text)) {
            setResult(Activity.RESULT_CANCELED, replyIntent)
        } else {
            val title = edittext_new_todo_entry_title.text.toString()
            val description = edittext_new_todo_entry_description.text.toString()

            replyIntent.putExtra(EXTRA_TODO_TITLE, title)
            replyIntent.putExtra(EXTRA_TODO_DESCRIPTION, description)
            replyIntent.putExtra(EXTRA_TODO_DUEDATE, dueDate)

            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }

    fun showDatePicker(view: View) {
        val datePickerFragment = DatePickerFragment()
        datePickerFragment.show(supportFragmentManager, "datePicker")
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        dueDate.set(year, month, day)
    }

    companion object {
        const val EXTRA_TODO_TITLE = "com.linh.to_dolist.TODO_TITLE"
        const val EXTRA_TODO_DESCRIPTION = "com.linh.to_dolist.TODO_DESCRIPTION"
        const val EXTRA_TODO_DUEDATE = "com.linh.to_dolist.TODO_DUEDATE"
    }
}
