package app.com.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.View


/**
 * Created by Pamuj Sharma
 */

object OkCancelDialog {

    fun show(context: Context, titleResId: String, message: String, okBtntext: String, okListener: View.OnClickListener?,
             cancelBtnText: String, cancelListener: View.OnClickListener?) {
        val adb = AlertDialog.Builder(context)
        adb.setTitle(titleResId)
        adb.setMessage(message)
        adb.setPositiveButton(okBtntext) { dialog, which ->
            okListener?.onClick(null)
        }


        adb.setNegativeButton(cancelBtnText) { dialog, which ->
            cancelListener?.onClick(null)
        }
        adb.show()
    }

}
