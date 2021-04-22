package com.odin.composesample.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SignUpViewModel @Inject constructor() : ViewModel() {

    private val _signUpStatus = MutableLiveData<SignUpStatus>()
    val signUpStatus: LiveData<SignUpStatus> get() = _signUpStatus

    fun changeStatus(signUpStatus: SignUpStatus) {
        _signUpStatus.value = signUpStatus
    }

}