package com.faturapay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class SignupViewModel : ViewModel() {
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val confirmPassword = MutableLiveData("")
    val isSignupSuccessful = MutableLiveData<Boolean?>(null)

    fun validateAndSignup() {
        if (email.value.isNullOrBlank() || password.value.isNullOrBlank() || confirmPassword.value.isNullOrBlank()) {
            isSignupSuccessful.value = false
        } else if (password.value != confirmPassword.value) {
            isSignupSuccessful.value = false
        } else {
            isSignupSuccessful.value = true
        }
    }
}
