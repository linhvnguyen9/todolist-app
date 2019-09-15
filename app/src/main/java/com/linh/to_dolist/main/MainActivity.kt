package com.linh.to_dolist.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.linh.to_dolist.R
import com.linh.to_dolist.TodoListApplication
import com.linh.to_dolist.ViewModelFactory
import com.linh.to_dolist.data.TodoEntry
import com.linh.to_dolist.databinding.ActivityMainBinding
import com.linh.to_dolist.newtodoentry.NewTodoEntryActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val todoViewModel by lazy {
        val repository = (applicationContext as TodoListApplication).todoRepository
        ViewModelFactory(repository).create(TodoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewmodel = todoViewModel

        setSupportActionBar(toolbar)

        val recyclerViewAdapter = TodoListAdapter(this)
        todo_recyclerview.adapter = recyclerViewAdapter
        todo_recyclerview.layoutManager = LinearLayoutManager(this)

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
        startActivity(intent)
    }

    companion object {
        private const val CREATE_ENTRY_REQUEST = 1
    }
}