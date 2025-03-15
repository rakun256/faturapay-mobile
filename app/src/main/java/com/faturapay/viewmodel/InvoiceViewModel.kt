package com.faturapay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.faturapay.data.mock.MockDataProvider
import com.faturapay.data.model.Invoice

class InvoiceViewModel : ViewModel() {
    private val _invoices = MutableStateFlow<List<Invoice>>(emptyList())
    val invoices: StateFlow<List<Invoice>> get() = _invoices

    init {
        loadInvoices()
    }

    private fun loadInvoices() {
        viewModelScope.launch {
            _invoices.value = MockDataProvider.getMockInvoices()
        }
    }

    fun addInvoice(invoice: Invoice) {
        viewModelScope.launch {
            _invoices.value = _invoices.value + invoice
        }
    }

    fun updateInvoice(updatedInvoice: Invoice) {
        viewModelScope.launch {
            _invoices.value = _invoices.value.map {
                if (it.id == updatedInvoice.id) updatedInvoice else it
            }
        }
    }

    fun deleteInvoice(invoice: Invoice) {
        viewModelScope.launch {
            _invoices.value = _invoices.value.filter { it.id != invoice.id }
        }
    }
}
