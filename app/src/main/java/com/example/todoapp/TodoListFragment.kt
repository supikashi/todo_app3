package com.example.todoapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.classes.Priority
import com.example.todoapp.classes.TodoItem
import com.example.todoapp.classes.TodoItemsAdapter
import com.example.todoapp.classes.TodoItemsRepository
import com.example.todoapp.databinding.FragmentTodoListBinding
import java.time.LocalDateTime


class TodoListFragment : Fragment() {
    lateinit var binding: FragmentTodoListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            (activity as MainActivity).replaceToAddTodoFragment()
        }

        val rv: RecyclerView = binding.lvTodoList
        val data = buildList()
        rv.adapter = TodoItemsAdapter(data, activity as MainActivity)
        rv.layoutManager = LinearLayoutManager(getContext())
    }

    companion object {

        @JvmStatic
        fun newInstance() = TodoListFragment()
    }

    fun buildList(): TodoItemsRepository {
        val list = TodoItemsRepository()
        list.AddTodoItem(
            TodoItem("1",
            "Купить что-то 1",
            Priority.NORMAL,
            false,
            LocalDateTime.now(),
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("1",
            "Купить что-то 2",
            Priority.LOW,
            true,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3",
            Priority.HIGH,
            false,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3 и еще и еще и еще и еще и еще и еще и еще и еще и еще",
            Priority.HIGH,
            true,
            LocalDateTime.now(),
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3",
            Priority.HIGH,
            true,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3",
            Priority.NORMAL,
            false,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3",
            Priority.HIGH,
            false,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3",
            Priority.HIGH,
            false,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3",
            Priority.HIGH,
            false,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
            "Купить что-то 3",
            Priority.HIGH,
            false,
            LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
                "много букв много букв много букв много букв много букв много букв много букв много буквмного буквмного букв много букв много букв много букв много буквмного букв много букв много букв много букв много букв много букв много букв много букв много букв много букв много букв много букв много букв много букв м много букв много букв много букв много букв много букв много букв много букв",
                Priority.HIGH,
                false,
                LocalDateTime.now(),
                LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
                "Купить что-то 3",
                Priority.HIGH,
                false,
                LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
                "Купить что-то 3",
                Priority.HIGH,
                false,
                LocalDateTime.now(),
                LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
                "Купить что-то 3",
                Priority.HIGH,
                false,
                LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
                "Купить что-то 3",
                Priority.HIGH,
                false,
                LocalDateTime.now())
        )
        list.AddTodoItem(
            TodoItem("3",
                "Купить что-то 3",
                Priority.HIGH,
                false,
                LocalDateTime.now())
        )
        return list
    }
}