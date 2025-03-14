package com.faturapay.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faturapay.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = viewModel()) {
    val invoices by viewModel.invoices.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Faturalar", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            itemsIndexed(invoices) { _, invoice ->
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
        }
    }
}
