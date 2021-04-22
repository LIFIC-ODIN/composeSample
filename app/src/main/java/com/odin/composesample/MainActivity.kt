package com.odin.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.odin.composesample.reservation.ui.ReservationHome
import com.odin.composesample.theme.ComposeDefaultTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeDefaultTheme {
                UIContent()
            }
        }
    }

    @Composable
    fun UIContent() {
        ReservationHome()
    }

    @Preview
    @Composable
    fun ShowDefault() {
        ComposeDefaultTheme {
            UIContent()
        }
    }
}