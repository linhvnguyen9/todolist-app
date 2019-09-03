package com.linh.to_dolist


import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import java.time.MonthDay
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class DatePickerFragment : DatePickerDialog.OnDateSetListener, DialogFragment() {
    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        val newTodoEntryActivity = (activity as NewTodoEntryActivity)
        newTodoEntryActivity.processDatePickerResult(year, month, day)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity!!, this, year, month, day)
    }
}
