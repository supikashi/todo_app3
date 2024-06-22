package com.example.todoapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.todoapp.databinding.FragmentAddTodoBinding

class AddTodoFragment : Fragment() {

    lateinit var binding: FragmentAddTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTodoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val date: TextView = binding.deadlineText
        date.setOnClickListener {
            SetDeadline(date)
        }
        binding.backButton.setOnClickListener {
            (activity as MainActivity).replaceToTodoListFragment()
        }
        binding.deleteButton.setOnClickListener {
            (activity as MainActivity).replaceToTodoListFragment()
        }
        binding.saveButton.setOnClickListener {
            (activity as MainActivity).replaceToTodoListFragment()
        }
        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                SetDeadline(date)
            } else {
                date.visibility = View.INVISIBLE
            }

        }
    }

    companion object {

        fun newInstance() = AddTodoFragment()
    }

    private fun SetDeadline(date: TextView) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(activity as MainActivity,
            { view, selectedYear, selectedMonth, selectedDay ->

                date.text = "$selectedDay.${selectedMonth + 1}.$selectedYear"

            }, year, month, day)
        datePickerDialog.show()
        date.visibility = View.VISIBLE
    }
}