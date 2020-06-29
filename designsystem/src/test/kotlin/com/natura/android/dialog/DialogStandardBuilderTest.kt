package com.natura.android.dialog

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DialogStandardBuilderTest {

    private val dialog = DialogStandard(ApplicationProvider.getApplicationContext(), R.style.Theme_Natura)

    @Test
    fun createsAlertDialogWithTitleWhenSetTitle() {
        dialog.setTitle("Teste")

        val dialogCreated = dialog.create()

        verify(dialog.alertDialog.setTitle("Test"))
    }
}