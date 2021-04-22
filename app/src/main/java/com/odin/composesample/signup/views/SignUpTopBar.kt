package com.odin.composesample.signup.views

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odin.composesample.R
import com.odin.composesample.signup.SignUpViewModel

@Preview
@Composable
fun SignUpTopBar() {
    TopAppBar(
        title = { Text("") },
        backgroundColor = colorResource(id = R.color.white),
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "back")
            }
        }
    )
}