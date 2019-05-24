package app.com.dialog

import android.app.Activity
import android.app.Dialog
import android.app.TimePickerDialog
import android.widget.TimePicker

import java.util.Calendar


/**
 * Created by Pamuj Sharma
 */
object TimeDialog {
    private val DATE_PICKER_ID = 1

    fun show(activity: Activity, title: String, calendar: Calendar?, listener: TimeDialogListener?) {
        var calendar = calendar
        if (null == calendar) {
            calendar = Calendar.getInstance()
        }

        val dialog = TimePickerDialog(activity, TimePickerDialog.OnTimeSetListener { timePicker, hour, minutes ->
            listener?.onTimeSet(hour, minutes)
        }, calendar!!.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false)
        dialog.show()
    }

    interface TimeDialogListener {
        fun onTimeSet(hour: Int, minute: Int)
    }
}
