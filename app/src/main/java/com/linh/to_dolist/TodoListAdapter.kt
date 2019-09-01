package com.linh.to_dolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoListAdapter(context: Context) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    private var todoEntries = emptyList<TodoEntry>()

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.todo_title
        val description = itemView.todo_title
        val dueDate = itemView.todo_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = inflater.inflate(R.layout.item_todo, parent, false)

        return TodoViewHolder(itemView)
    }

    override fun getItemCount(): Int = todoEntries.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentEntry = todoEntries[position]

        holder.title.text = currentEntry.title
        holder.description.text = currentEntry.description
        holder.dueDate.text = currentEntry.dueDate.toString()
    }

    internal fun setEntries(entry: List<TodoEntry>) {
        this.todoEntries = entry
        notifyDataSetChanged()
    }
}