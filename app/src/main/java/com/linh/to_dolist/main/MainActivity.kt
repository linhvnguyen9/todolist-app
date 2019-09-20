package com.linh.to_dolist.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.linh.to_dolist.R
import com.linh.to_dolist.databinding.ActivityMainBinding
import com.linh.to_dolist.newtodoentry.NewTodoEntryActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val todoViewModel: TodoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBinding()
        setSupportActionBar(toolbar)
        setupRecyclerView()
        setupFabOnClickListener()
    }

    private fun setupFabOnClickListener() {
        fab.setOnClickListener {
            onCreateTodoEntryClickListener()
        }
    }

    private fun setupRecyclerView() {
        val recyclerViewAdapter = TodoListAdapter()
        todo_recyclerview.adapter = recyclerViewAdapter
        todo_recyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun setupDataBinding() {
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewmodel = todoViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onCreateTodoEntryClickListener() {
        val intent = Intent(this, NewTodoEntryActivity::class.java)
        startActivity(intent)
    }
}