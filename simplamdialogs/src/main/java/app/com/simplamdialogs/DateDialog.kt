package app.com.dialog

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.widget.DatePicker

import java.util.Calendar

/**
 * Created by Pamuj Sharma .
 */
object DateDialog {
    private val DATE_PICKER_ID = 0

    fun show(activity: Activity, title: String, calendar: Calendar?, listener: DateDialogListener?) {
        var calendar = calendar
        if (null == calendar) {
            calendar = Calendar.getInstance()
        }

        val dialog = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
            if (null != listener) {
                val cal = Calendar.getInstance()
                cal.set(selectedYear, selectedMonth, selectedDay)
                listener.onDateSet(cal)
            }
        }, calendar!!.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        dialog.show()
    }

   open interface DateDialogListener {
        fun onDateSet(calendar: Calendar)
    }
}
