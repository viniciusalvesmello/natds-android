package com.natura.android.dialog

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.natura.android.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

@RunWith(AndroidJUnit4::class)
class DialogStandardBuilderTest {
    lateinit var parameters: DialogStandardParameters

    @Mock
    lateinit var builder: AlertDialog.Builder

    lateinit var dialogStandardBuilder: DialogStandardBuilder
    lateinit var clickListener: DialogInterface.OnClickListener

    @Before
    fun setUp() {
        initMocks(this)

        `when`(builder.create()).thenReturn(AlertDialog.Builder(ApplicationProvider.getApplicationContext()).create())

        clickListener = DialogInterface.OnClickListener { _, _ -> }

        parameters = DialogStandardParameters(
            R.string.title_to_test_dialog,
            R.layout.layout_to_test_dialog,
            null,
            R.string.main_button_to_test_dialog,
            clickListener,
            R.string.secondary_button_to_test_dialog,
            clickListener,
            true)

        dialogStandardBuilder = DialogStandardBuilder(builder, parameters)
    }

    @Test
    fun setAlertDialogTitleWithDataFromParameters() {
        dialogStandardBuilder.create()

        verify(builder).setTitle(R.string.title_to_test_dialog)
    }

    @Test
    fun setAlertDialogContentLayoutWithDataFromParameters() {
        dialogStandardBuilder.create()

        verify(builder).setView(R.layout.layout_to_test_dialog)
    }

    @Test
    fun setAlertDialogContentWithDataFromParameters() {
        val customView = View(ApplicationProvider.getApplicationContext())
        parameters = provideParametersWithCustomView(customView)
        dialogStandardBuilder = DialogStandardBuilder(builder, parameters)

        dialogStandardBuilder.create()

        verify(builder).setView(customView)
    }

    @Test
    fun setAlertDialogMainButtonWithDataFromParameters() {
        dialogStandardBuilder.create()

        verify(builder).setPositiveButton(R.string.main_button_to_test_dialog, clickListener)
    }

    @Test
    fun setAlertDialogSecondaryButtonWithDataFromParameters() {
        dialogStandardBuilder.create()

        verify(builder).setNegativeButton(R.string.secondary_button_to_test_dialog, clickListener)
    }

    @Test
    fun setAlertDialogIsCancelableWithDataFromParameters() {
        dialogStandardBuilder.create()

        verify(builder).setCancelable(true)
    }

    @Test
    fun createsAlertDialogWhenCallCreateMethodFromBuilder() {
        dialogStandardBuilder.create()

        verify(builder).create()
    }

    private fun provideParametersWithCustomView(customView: View): DialogStandardParameters {
        return DialogStandardParameters(
                R.string.title_to_test_dialog,
                null,
                customView,
                R.string.main_button_to_test_dialog,
                clickListener,
                R.string.secondary_button_to_test_dialog,
                clickListener,
                true)
    }
}