package com.odin.composesample.signup.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odin.composesample.R
import com.odin.composesample.signup.SignUpStatus
import com.odin.composesample.signup.SignUpViewModel

@Preview
@Composable
fun SignUpBottomBar() {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(id = R.color.purple_1),
        contentColor = MaterialTheme.colors.surface
    )
    val signUpViewModel: SignUpViewModel = viewModel()

    Row {
        Button(
            colors = mainButtonColor,
            onClick = {
                signUpViewModel.changeStatus(
                    when (signUpViewModel.signUpStatus.value) {
                        SignUpStatus.None -> SignUpStatus.MakeEmail
                        else -> SignUpStatus.None
                    }
                )
            },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Text(text = "다음", color = colorResource(id = R.color.gray090))
        }
    }
}