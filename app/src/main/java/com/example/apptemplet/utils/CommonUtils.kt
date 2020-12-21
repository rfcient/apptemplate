package com.example.apptemplet.utils

import android.app.Activity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity

fun dialogYesOrNo(
    activity: FragmentActivity,
    title: String,
    message: String,
    listener: DialogInterface.OnClickListener
) {
    val builder = AlertDialog.Builder(activity)
    builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
        dialog.dismiss()
        listener.onClick(dialog, id)
    })
    builder.setNegativeButton("No", null)
    val alert = builder.create()
    alert.setTitle(title)
    alert.setMessage(message)
    alert.show()
}