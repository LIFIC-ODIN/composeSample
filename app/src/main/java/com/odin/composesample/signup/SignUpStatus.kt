package com.odin.composesample.signup

sealed class SignUpStatus {
    object None : SignUpStatus()
    object MakeEmail : SignUpStatus()
    object MakePassword : SignUpStatus()
}