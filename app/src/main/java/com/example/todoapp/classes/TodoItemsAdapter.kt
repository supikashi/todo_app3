package com.example.todoapp.classes

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.MainActivity
import com.example.todoapp.R

class TodoItemsAdapter(
    private val dataSet: TodoItemsRepository,
    private val activity: MainActivity
) : RecyclerView.Adapter<TodoItemsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.todoItemText)
        val isCompleted: CheckBox = view.findViewById(R.id.todoItemDone)
        val priority: ImageView = view.findViewById(R.id.priorityImage)
        val deadline: TextView = view.findViewById(R.id.todoItemDeadline)
        val info: ImageView = view.findViewById(R.id.infoOutline)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.todo_item_cell, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet.GetList()[position]
        holder.text.text = item.text
        holder.isCompleted.isChecked = item.isCompleted
        if (item.isCompleted) {
            holder.text.paintFlags = holder.text.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            holder.text.setTextColor(ContextCompat.getColor(activity, R.color.label_tertiary))
        }
        when (item.priority) {
            Priority.LOW -> holder.priority.setImageResource(R.drawable.ic_low_priority_todo)
            Priority.NORMAL -> holder.priority.visibility = View.GONE
            Priority.HIGH -> {
                holder.priority.setImageResource(R.drawable.ic_high_priority_todo)
                //holder.isCompleted.buttonTintList =
            }
        }
        if (item.deadline == null) {
            holder.deadline.visibility = View.GONE
        } else {
            holder.deadline.text = "${item.deadline.dayOfMonth}.${item.deadline.monthValue}.${item.deadline.year}"
        }
        holder.itemView.setOnClickListener {
            activity.replaceToAddTodoFragment()
        }
        holder.isCompleted.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.text.paintFlags = holder.text.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                holder.text.setTextColor(ContextCompat.getColor(activity, R.color.label_tertiary))
            } else {
                holder.text.paintFlags = holder.text.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                holder.text.setTextColor(ContextCompat.getColor(activity, R.color.label_primary))
            }
        }
    }

    override fun getItemCount() = dataSet.GetList().size
}