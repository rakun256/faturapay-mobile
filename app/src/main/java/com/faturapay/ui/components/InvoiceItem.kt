package com.faturapay.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faturapay.data.model.Invoice
import com.faturapay.ui.theme.LightPrimary
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun InvoiceItem(invoice: Invoice, onEdit: (Invoice) -> Unit, onDelete: (Invoice) -> Unit) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = LightPrimary),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = invoice.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Tutar: ${invoice.amount} TL", style = MaterialTheme.typography.bodySmall)
            Text(text = "Son Ödeme: ${dateFormat.format(invoice.dueDate)}", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { onEdit(invoice) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Düzenle")
                }
                IconButton(onClick = { onDelete(invoice) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Sil")
                }
            }
        }
    }
}
