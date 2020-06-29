package com.natura.android.dialog

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog

class DialogStandard constructor(context: Context, private val theme: Int, builder: AlertDialog.Builder = AlertDialog.Builder(context)) {
    private lateinit var parameters: DialogStandardParameters
    private val builder = AlertDialog.Builder(context, theme)
    lateinit var dialog: AlertDialog

    fun setTitle(titleResource: Int) {
        parameters.title = titleResource
    }

    fun setContentByLayout(layoutResource: Int) {
        parameters.layoutResource = layoutResource
    }

    fun setContentByView(view: View) {
        parameters.view = view
    }

    fun setMainButtonAction(action: DialogInterface.OnClickListener) {
        parameters.mainButtonAction = action
    }

    fun secondaryMainButtonAction(action: DialogInterface.OnClickListener) {
        parameters.secondaryButtonAction = action
    }

    fun create(): DialogStandardBuilder {
        this.dialog = DialogStandardBuilder(builder, parameters).create()
        return this
    }

    fun show() {
        this.dialog.show()
    }

    //colocar AlertDialog.Builder num construtor interno pra mockar
    inner class DialogStandardBuilder(val builder: AlertDialog.Builder, val parameters: DialogStandardParameters) {
        fun create (): AlertDialog {

            builder.setTitle(parameters.title)

            builder.setView(parameters.view)

            return builder.create()
        }

    }

    inner class DialogStandardParameters {

        lateinit var secondaryButtonAction: DialogInterface.OnClickListener
        lateinit var mainButtonAction: DialogInterface.OnClickListener
        lateinit var view: View
        var layoutResource: Int
        var title: Int
    }

//    private val dialogBuilder = AlertDialog.Builder(context, theme)
//    private lateinit var  dialog: AlertDialog

    private fun create (dialogBuilder, parameters) {
        //cria um dialogStandard(dialogBuilder, parameters)
    }





//    fun setTitle(title: String) {
//        dialogBuilder.setTitle(title)
//    }
//
//    fun setTitle(titleResource: Int) {
//        dialogBuilder.setTitle(titleResource)
//    }
//
//    fun setContent(contentLayout: Int) {
//        dialogBuilder.setView(contentLayout)
//    }
//
//    fun setContent(view: View) {
//        dialogBuilder.setView(view)
//    }
//
//    fun setMainActionButton(buttonLabel: String, listener: DialogInterface.OnClickListener) {
//        dialogBuilder.setPositiveButton(buttonLabel, listener)
//    }
//
//    fun setMainActionButton(buttonLabelResource: Int, listener: DialogInterface.OnClickListener) {
//        dialogBuilder.setPositiveButton(buttonLabelResource, listener)
//    }
//
//    fun setSecondaryActionButton(buttonLabel: String, listener: DialogInterface.OnClickListener) {
//        dialogBuilder.setNegativeButton(buttonLabel, listener)
//    }
//
//    fun setSecondaryActionButton(buttonLabelResource: Int, listener: DialogInterface.OnClickListener) {
//        dialogBuilder.setNegativeButton(buttonLabelResource, listener)
//    }
//
//    fun setCancelable(isCancelable: Boolean) {
//        dialogBuilder.setCancelable(isCancelable)
//    }
//
//    fun setOnCancelListener(onCancelListener: DialogInterface.OnCancelListener) {
//        dialogBuilder.setOnCancelListener(onCancelListener)
//    }
//
//    fun setOnDismissListener(onDismissListener: DialogInterface.OnDismissListener) {
//        dialogBuilder.setOnDismissListener(onDismissListener)
//    }
//
//    //retornar objeto mais genérico*
//    fun create(): AlertDialog {
//        dialog = dialogBuilder.create()
//        return dialog
//    }

}