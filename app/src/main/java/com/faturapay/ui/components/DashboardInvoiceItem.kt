package com.faturapay.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faturapay.data.model.Invoice
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DashboardInvoiceItem(invoice: Invoice) {
    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = invoice.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Tutar: ${invoice.amount} TL", style = MaterialTheme.typography.bodySmall)
            Text(
                text = "Son Ödeme: ${dateFormatter.format(invoice.dueDate)}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
