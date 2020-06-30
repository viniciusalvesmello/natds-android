package com.natura.android.dialog
import androidx.appcompat.app.AlertDialog

class DialogStandardBuilder(private val builder: AlertDialog.Builder, private val parameters: DialogStandardParameters) {

    fun create(): AlertDialog {
        builder.setTitle(parameters.titleResource)
        builder.setPositiveButton(parameters.mainButtonTitle, parameters.mainButtonAction)
        builder.setNegativeButton(parameters.secondaryButtonTitle, parameters.secondaryButtonAction)
        builder.setCancelable(parameters.isCancelable)
        setDialogContent()

        return builder.create()
    }

    private fun setDialogContent() {
        if(parameters.contentLayout != null) {
            builder.setView(parameters.contentLayout)
        } else if (parameters.contentView != null) {
            builder.setView(parameters.contentView)
        }
    }
}
