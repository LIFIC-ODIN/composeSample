package com.odin.composesample.signup.views

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odin.composesample.R
import com.odin.composesample.signup.SignUpViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@Preview
@Composable
fun EmailBoarding() {
    var loggedIn by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    Crossfade(targetState = loggedIn) {
        EmailView {
            coroutineScope.launch {
                delay(2000)
                loggedIn = true
            }
        }
    }
}

@Composable
fun EmailView(onLoginSuccess: () -> Unit) {
    Scaffold {
        var email by remember { mutableStateOf(TextFieldValue("")) }
        val hasError by remember { mutableStateOf(false) }
        val emailInteractionState = remember { MutableInteractionSource() }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item {
                Text(
                    text = "이메일 주소를 입력해주세요.",
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(id = R.color.black_1),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            item { Spacer(modifier = Modifier.height(47.dp)) }
            item {
                OutlinedTextField(
                    value = email,
                    maxLines = 1,
                    isError = hasError,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    label = { Text(text = "이메일") },
                    placeholder = { Text(text = "lific@lific.io") },
                    onValueChange = {
                        email = it
                    },
                    interactionSource = emailInteractionState,
                )
            }
        }
    }
}