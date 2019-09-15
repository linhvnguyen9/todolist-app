package com.linh.to_dolist.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.linh.to_dolist.data.TodoEntry
import com.linh.to_dolist.databinding.ItemTodoBinding

class TodoListAdapter : ListAdapter<TodoEntry, TodoListAdapter.TodoViewHolder>(TodoDiffCallback()) {

    private val TAG = TodoListAdapter::class.java.simpleName

    class TodoViewHolder private constructor(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoEntry) {
            binding.entry = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TodoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)

                return TodoViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }
}

class TodoDiffCallback : DiffUtil.ItemCallback<TodoEntry>() {
    override fun areItemsTheSame(oldItem: TodoEntry, newItem: TodoEntry): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoEntry, newItem: TodoEntry): Boolean {
        return oldItem == newItem
    }
}