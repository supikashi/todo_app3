package com.example.todoapp.classes

import java.time.LocalDateTime

data class TodoItem(
    val id: String,
    val text: String,
    val priority: Priority,
    val isCompleted: Boolean,
    val createdDate: LocalDateTime,
    val deadline: LocalDateTime? = null,
    val modifiedDate: LocalDateTime? = null
)

enum class Priority {
    LOW,
    NORMAL,
    HIGH
}
