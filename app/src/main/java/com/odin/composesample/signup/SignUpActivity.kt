package com.odin.composesample.signup

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.odin.composesample.signup.views.EmailBoarding
import com.odin.composesample.signup.views.PasswordBoarding
import com.odin.composesample.signup.views.SignUpBottomBar
import com.odin.composesample.signup.views.SignUpTopBar
import com.odin.composesample.theme.ComposeDefaultTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        setContent {
            ShowLoginView()
        }
    }

    private fun observer() {
        val isOwner = this
        signUpViewModel.run {
            signUpStatus.observe(isOwner) {
                when (it) {
                    SignUpStatus.None -> {
                    }
                    SignUpStatus.MakeEmail -> {
                    }
                    SignUpStatus.MakePassword -> {
                    }
                    else -> {
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun ShowLoginView() {
        ComposeDefaultTheme {
            Scaffold(
                topBar = {
                    SignUpTopBar()
                },
                content = {
//                    EmailBoarding()
                    PasswordBoarding()
                },
                bottomBar = {
                    SignUpBottomBar()
                }
            )
        }
    }

}