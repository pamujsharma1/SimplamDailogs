package app.com.dialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View


/**
 * Created by Pamuj Sharma .
 */
object OKDialog {

    fun showNotCancelable(baseView: Context, title: String, message: String, okListener: View.OnClickListener?,
             cancelListener: DialogInterface.OnCancelListener) {
        val builder = AlertDialog.Builder(baseView)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK") { dialog, which ->
                    okListener?.onClick(View(baseView))
                }
        builder.setCancelable(false)
        builder.setOnCancelListener(cancelListener)
        builder.show()
    }

    fun showWithoutListener(mcContext: Context, no_network: Int, s: String) {
        AlertDialog.Builder(mcContext)
                .setTitle(mcContext.resources.getString(no_network))
                .setMessage(s)
                .setPositiveButton("OK") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
    }

    fun showOk(mcContext: Context, title: String, s: String,onClickListener: View.OnClickListener) {
        AlertDialog.Builder(mcContext)
                .setTitle(title)
                .setMessage(s)
                .setPositiveButton("OK") { dialog, which ->
                    dialog.dismiss()
                    onClickListener.onClick(null)
                }
                .show()
    }
}
