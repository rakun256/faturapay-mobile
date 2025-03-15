package com.faturapay.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faturapay.data.model.Invoice
import com.faturapay.ui.theme.AccentColor

@Composable
fun EditInvoiceDialog(invoice: Invoice, onDismiss: () -> Unit, onSave: (Invoice) -> Unit) {
    var title by remember { mutableStateOf(invoice.title) }
    var amount by remember { mutableStateOf(invoice.amount.toString()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Faturayı Düzenle") },
        text = {
            Column {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Fatura Başlığı") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = amount,
                    onValueChange = { amount = it },
                    label = { Text("Tutar (TL)") }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val updatedInvoice = invoice.copy(
                        title = title,
                        amount = amount.toDoubleOrNull() ?: invoice.amount
                    )
                    onSave(updatedInvoice)
                },
                colors = ButtonDefaults.buttonColors(containerColor = AccentColor)
            ) {
                Text("Kaydet")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("İptal")
            }
        }
    )
}
