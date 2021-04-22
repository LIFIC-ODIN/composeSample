package com.odin.composesample.learn.ui.views

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

class AlertDialogSample: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AlertDialogSample()
        }
    }

    @Preview
    @Composable
    fun AlertDialogSample() {
        MaterialTheme {
            Column {
                val openDialog = remember { mutableStateOf(false)  }

                Button(onClick = {
                    openDialog.value = true
                }) {
                    Text("Click")
                }

                if (openDialog.value) {

                    AlertDialog(
                        onDismissRequest = {
                            // Dismiss the dialog when the user clicks outside the dialog or on the back
                            // button. If you want to disable that functionality, simply use an empty
                            // onCloseRequest.
                            openDialog.value = false
                        },
                        title = {
                            Text(text = "Dialog Title")
                        },
                        text = {
                            Text("Here is a text ")
                        },
                        confirmButton = {
                            Button(

                                onClick = {
                                    openDialog.value = false
                                }) {
                                Text("This is the Confirm Button")
                            }
                        },
                        dismissButton = {
                            Button(

                                onClick = {
                                    openDialog.value = false
                                }) {
                                Text("This is the dismiss Button")
                            }
                        }
                    )
                }
            }

        }
    }

}