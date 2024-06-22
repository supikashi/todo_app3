package com.example.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.classes.Priority
import com.example.todoapp.classes.TodoItem
import com.example.todoapp.classes.TodoItemsAdapter
import com.example.todoapp.classes.TodoItemsRepository
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_holder, TodoListFragment.newInstance())
            .commit()

        //val view: FragmentContainerView = findViewById(R.id.fragment_todo_list_view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun replaceToAddTodoFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_holder, AddTodoFragment.newInstance())
            .commit()
    }
    public fun replaceToTodoListFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_holder, TodoListFragment.newInstance())
            .commit()
    }

}