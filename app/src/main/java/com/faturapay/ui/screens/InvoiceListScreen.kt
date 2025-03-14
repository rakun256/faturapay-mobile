package com.faturapay.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faturapay.viewmodel.InvoiceViewModel
import com.faturapay.ui.theme.LightPrimary
import com.faturapay.data.model.Invoice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvoiceListScreen(viewModel: InvoiceViewModel = viewModel()) {
    val invoices by viewModel.invoices.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Faturalar") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = LightPrimary)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn {
                items(invoices) { invoice ->
                    InvoiceItem(invoice)
                }
            }
        }
    }
}

@Composable
fun InvoiceItem(invoice: Invoice) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = invoice.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Tutar: ${invoice.amount} TL", style = MaterialTheme.typography.bodySmall)
            Text(text = "Son Ödeme: ${invoice.dueDate}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
