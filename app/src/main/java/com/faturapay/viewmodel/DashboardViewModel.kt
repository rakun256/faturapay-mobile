package com.faturapay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.faturapay.data.mock.MockDataProvider
import com.faturapay.data.model.Invoice
import com.faturapay.data.model.Subscription

class DashboardViewModel : ViewModel() {

    private val _invoices = MutableLiveData<List<Invoice>>()
    val invoices: LiveData<List<Invoice>> get() = _invoices

    private val _subscriptions = MutableLiveData<List<Subscription>>()
    val subscriptions: LiveData<List<Subscription>> get() = _subscriptions

    init {
        loadMockData()
    }

    private fun loadMockData() {
        _invoices.value = MockDataProvider.getMockInvoices()
        _subscriptions.value = MockDataProvider.getMockSubscriptions()
    }
}
