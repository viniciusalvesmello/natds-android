package com.natura.android.dialog

import android.content.DialogInterface
import android.view.View

data class DialogStandardParameters @JvmOverloads constructor(
    var titleResource: Int,
    var contentLayout: Int? = null,
    var contentView: View? = null,
    var mainButtonTitle: Int,
    var mainButtonAction: DialogInterface.OnClickListener,
    var secondaryButtonTitle: Int,
    var secondaryButtonAction: DialogInterface.OnClickListener,
    var isCancelable: Boolean) {
}