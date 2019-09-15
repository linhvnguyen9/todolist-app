package com.linh.to_dolist.newtodoentry


import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.linh.to_dolist.newtodoentry.NewTodoEntryActivity
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
