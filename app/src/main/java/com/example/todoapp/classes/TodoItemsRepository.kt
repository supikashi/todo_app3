package com.example.todoapp.classes

class TodoItemsRepository(private val list: ArrayList<TodoItem> = ArrayList()) {
    fun GetList() = list
    fun AddTodoItem(item: TodoItem) {
        list.add(item)
    }
}