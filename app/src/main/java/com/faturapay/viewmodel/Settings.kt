package com.faturapay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SettingsViewModel : ViewModel() {
    private val _darkModeEnabled = MutableLiveData(false)
    val darkModeEnabled: LiveData<Boolean> = _darkModeEnabled

    fun toggleDarkMode() {
        _darkModeEnabled.value = !(_darkModeEnabled.value ?: false)
    }
}
