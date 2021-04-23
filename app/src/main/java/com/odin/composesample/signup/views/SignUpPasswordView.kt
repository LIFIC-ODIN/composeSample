package com.odin.composesample.signup.views

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
fun PasswordBoarding() {
    var loggedIn by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    Crossfade(targetState = loggedIn) {
        PassWordView {
            coroutineScope.launch {
                delay(2000)
                loggedIn = true
            }
        }
    }
}

@Composable
fun PassWordView(onLoginSuccess: () -> Unit) {
    Scaffold {
        val visibleIcon = Icons.Filled.VisibilityOff
        val goneIcon = Icons.Filled.Visibility

        var password1 by remember { mutableStateOf(TextFieldValue("")) }
        var password2 by remember { mutableStateOf(TextFieldValue("")) }

        val hasError by remember { mutableStateOf(false) }

        var passwordVisualTransformation1 by remember {
            mutableStateOf<VisualTransformation>(
                PasswordVisualTransformation()
            )
        }
        val passwordInteractionState2 = remember { MutableInteractionSource() }

        var passwordVisualTransformation2 by remember {
            mutableStateOf<VisualTransformation>(
                PasswordVisualTransformation()
            )
        }
        val passwordInteractionState1 = remember { MutableInteractionSource() }

        val Pass1Icon = visibleIcon
        val Pass2Icon = goneIcon

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item {
                Text(
                    text = "비밀번호를 입력해주세요.",
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(id = R.color.black_1),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            item { Spacer(modifier = Modifier.height(47.dp)) }
            item {
                OutlinedTextField(
                    value = password1,
                    trailingIcon = {
                        Icon(Pass1Icon,
                            contentDescription = "see",
                            modifier = Modifier.clickable(
                                onClick = {
                                    passwordVisualTransformation1 =
                                        if (passwordVisualTransformation1 != VisualTransformation.None) {
                                            VisualTransformation.None
                                        } else {
                                            PasswordVisualTransformation()
                                        }
                                }
                            ))
                    },
                    maxLines = 1,
                    isError = hasError,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    label = { Text(text = "비밀번호") },
                    placeholder = { Text(text = "") },
                    onValueChange = {
                        password1 = it
                    },
                    interactionSource = passwordInteractionState1,
                    visualTransformation = passwordVisualTransformation1,
                )
            }
            item {
                Text(
                    text = "문자, 숫자, 기호를 조합하여 8자 이상을 사용하세요.",
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(id = R.color.gray010),
                    fontSize = 11.sp
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                OutlinedTextField(
                    value = password2,
                    trailingIcon = {
                        Icon(Pass2Icon,
                            contentDescription = "see",
                            modifier = Modifier.clickable(
                                onClick = {
                                    passwordVisualTransformation2 =
                                        if (passwordVisualTransformation2 != VisualTransformation.None) {
                                            VisualTransformation.None
                                        } else {
                                            PasswordVisualTransformation()
                                        }
                                }
                            ))
                    },
                    maxLines = 1,
                    isError = hasError,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    label = { Text(text = "비밀번호 확인") },
                    placeholder = { Text(text = "") },
                    onValueChange = {
                        password2 = it
                    },
                    interactionSource = passwordInteractionState2,
                    visualTransformation = passwordVisualTransformation2,
                )
            }
        }
    }
}