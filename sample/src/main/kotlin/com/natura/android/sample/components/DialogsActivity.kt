package com.natura.android.sample.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.natura.android.sample.R
import kotlinx.android.synthetic.main.activity_dialogs.*

class DialogsActivity : AppCompatActivity() {
    lateinit var testDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        buildDialog()

        standardDialogButton.setOnClickListener {
            testDialog.show()
        }
    }

    private fun buildDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("teste Alert Dialog")
        dialogBuilder.setView(R.layout.content_standard_dialog)
        dialogBuilder.setPositiveButton("Sem dúvidas") { dialog, id ->
            Toast.makeText(this, "Uhuuull", Toast.LENGTH_LONG).show()
        }
        dialogBuilder.setNegativeButton("Fechar") { dialog, id ->
            dialog.dismiss()
        }
        testDialog = dialogBuilder.create()
    }
}
