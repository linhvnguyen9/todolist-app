package com.linh.to_dolist.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.linh.to_dolist.data.TodoEntry

@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, entries: List<TodoEntry>?) {
    if (entries == null) {
        return
    }
    (recyclerView.adapter as TodoListAdapter).submitList(entries)
}