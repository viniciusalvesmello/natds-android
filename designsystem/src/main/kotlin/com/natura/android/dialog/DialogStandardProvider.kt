package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog

class DialogStandardProvider constructor(context: Context, private val theme: Int, builder: AlertDialog.Builder = AlertDialog.Builder(context)) {
//    private lateinit var parameters: DialogStandardParameters
//    private val innerBuilder = AlertDialog.Builder(context, theme)
//    lateinit var dialogBuild: AlertDialog
//
//    fun setTitle(titleResource: Int) {
//        parameters.titleResource = titleResource
//    }
//
//    fun setContentByLayout(layoutResource: Int) {
//        parameters.contentLayout = layoutResource
//    }
//
//    fun setContentByView(view: View) {
//        parameters.contentView = view
//    }
//
//    fun setMainButtonAction(action: DialogInterface.OnClickListener) {
//        parameters.mainButtonAction = action
//    }
//
//    fun secondaryMainButtonAction(action: DialogInterface.OnClickListener) {
//        parameters.secondaryButtonAction = action
//    }
//
//    fun create(): DialogStandardBuilder {
//        this.dialogBuild = DialogStandardBuilder(innerBuilder, parameters).create()
//        return this
//    }
//
//    fun show() {
//        this.dialogBuild.show()
//    }
//
//
//    //retornar objeto mais genérico*
//    fun create(): AlertDialog {
//        dialog = dialogBuilder.create()
//        return dialog
//    }

}