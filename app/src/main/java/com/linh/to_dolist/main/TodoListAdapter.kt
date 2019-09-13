package com.linh.to_dolist.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.linh.to_dolist.R
import com.linh.to_dolist.data.TodoEntry
import kotlinx.android.synthetic.main.item_todo.view.*
import java.util.*

class TodoListAdapter(context: Context) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {
    private val TAG = TodoListAdapter::class.java.simpleName

    private val inflater = LayoutInflater.from(context)
    private var todoEntries = emptyList<TodoEntry>()

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.todo_title
        val description = itemView.todo_description
        val dueDate = itemView.todo_duedate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = inflater.inflate(R.layout.item_todo, parent, false)

        return TodoViewHolder(itemView)
    }

    override fun getItemCount(): Int = todoEntries.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentEntry = todoEntries[position]

        Log.d(TAG, currentEntry.toString())

        holder.title.text = currentEntry.title
        holder.description.text = currentEntry.description
        val date = currentEntry.dueDate
        holder.dueDate.text = "${date.get(Calendar.DAY_OF_MONTH)} ${date.get(Calendar.MONTH) + 1} ${date.get(Calendar.YEAR)}"
    }

    internal fun setEntries(entry: List<TodoEntry>) {
        this.todoEntries = entry
        notifyDataSetChanged()
    }
}