package app.com.dialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface


/**
 * Created by Pamuj Sharma .
 */
object ListDialog {
    fun show(context: Context, title: String?, listener: ListDialogListener?, vararg options: String) {
        val builder = AlertDialog.Builder(context)
        if (null != title && title.trim { it <= ' ' }.length > 0) {
            builder.setTitle(title)
        }
        builder.setItems(options) { dialog, item ->
            listener?.onItemClick(item, options[item])
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
            listener?.onCancel()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    interface ListDialogListener {
        fun onItemClick(position: Int, item: String)

        fun onCancel()
    }
}
