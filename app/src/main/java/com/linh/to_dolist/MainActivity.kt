package com.linh.to_dolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val todoViewModel by lazy { ViewModelProvider(this).get(TodoViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerViewAdapter = TodoListAdapter(this)
        todo_recyclerview.adapter = recyclerViewAdapter
        todo_recyclerview.layoutManager = LinearLayoutManager(this)

        todoViewModel.allTodoEntries.observe(this, androidx.lifecycle.Observer { entries ->
            entries?.let { recyclerViewAdapter.setEntries(it) }
        })

        fab.setOnClickListener { view ->
            onCreateTodoEntryClickListener(view)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onCreateTodoEntryClickListener(view: View) {
        val intent = Intent(this, NewTodoEntryActivity::class.java)
        startActivityForResult(intent, CREATE_ENTRY_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_ENTRY_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    val title = it.getStringExtra(NewTodoEntryActivity.EXTRA_TODO_TITLE)
                    val description = it.getStringExtra(NewTodoEntryActivity.EXTRA_TODO_DESCRIPTION)
                    val dueDate = it.getSerializableExtra(NewTodoEntryActivity.EXTRA_TODO_DUEDATE)

                    val entry = TodoEntry(
                        title,
                        description,
                        dueDate as Calendar
                    ) //TODO: Change to user defined date

                    Log.d("onActivityResult", dueDate.toString())

                    todoViewModel.insert(entry)
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Empty entry not added", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val CREATE_ENTRY_REQUEST = 1
    }
}

