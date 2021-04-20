package com.odin.composesample.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odin.composesample.R

class ColumnSample {

    @Preview
    @Composable
    fun ColumnExample() {

        val typography = MaterialTheme.typography

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(5.dp)), contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text("Hello World!", style = typography.h4)
            Text("Hello World!2", style = typography.body2)
            Text("button", style = typography.button)
        }
    }
}