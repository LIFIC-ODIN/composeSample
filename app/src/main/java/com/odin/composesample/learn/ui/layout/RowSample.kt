package com.odin.composesample.learn.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RowSample {

    @Preview
    @Composable
    fun RowExample() {
        Row(horizontalArrangement = Arrangement.Center) {
            Text("Hello World!")
            Text(
                "Hello World!2",
                Modifier
                    .height(150.dp)
                    .size(100.dp)
                    .background(Color.Green),
                fontSize = 10.sp, color = Color.White, fontWeight = Bold
            )
        }
    }
}