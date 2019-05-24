package app.com.dialog

import android.graphics.drawable.ColorDrawable
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import app.com.simplamdialogs.R


object CustomDialog {
    fun showDialogCustomOk(context: Context, message: String, onClickListener: OnClickListener) {
        var myDialog = Dialog(context)
        myDialog.setContentView(R.layout.custompopup)
        myDialog.setCancelable(true)
        val textTitle = myDialog.findViewById<TextView>(R.id.textTitle)
        textTitle.text = message
        val close = myDialog.findViewById<ImageView>(R.id.close)
        close.setOnClickListener {
            myDialog.dismiss()
        }
        val cancelBtn = myDialog.findViewById<Button>(R.id.cancelBtn)
        cancelBtn.visibility = View.GONE
        val ok = myDialog.findViewById<Button>(R.id.ok)
        ok.setOnClickListener {
            onClickListener.onClickButtonOk()
            myDialog.dismiss()
        }
        myDialog.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()

    }

    fun showDialogCustomOkCancel(context: Context, message: String, onClickListener: OnClickListener) {
        var myDialog = Dialog(context)
        myDialog.setContentView(R.layout.custompopup)
        myDialog.setCancelable(false)

        val textTitle = myDialog.findViewById<TextView>(R.id.textTitle)
        textTitle.text = message

        val close = myDialog.findViewById<ImageView>(R.id.close)
        close.setOnClickListener {
            myDialog.dismiss()
        }
        val cancelBtn = myDialog.findViewById<Button>(R.id.cancelBtn)
        cancelBtn.setOnClickListener {
            myDialog.dismiss()
        }
        val ok = myDialog.findViewById<Button>(R.id.ok)
        ok.setOnClickListener {
            onClickListener.onClickButtonOk()
            myDialog.dismiss()
        }
        myDialog.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()

    }

    interface OnClickListener {
        fun onClickButtonOk()
    }
}