package com.faturapay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class LoginViewModel : ViewModel() {
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val isLoginSuccessful = MutableLiveData<Boolean?>(null)

    fun validateAndLogin() {
        if (email.value.isNullOrBlank() || password.value.isNullOrBlank()) {
            isLoginSuccessful.value = false
        } else {
            // Test kullanıcı bilgileri: test@faturapay.com, 123456
            isLoginSuccessful.value = email.value == "test@faturapay.com" && password.value == "123456"
        }
    }
}
