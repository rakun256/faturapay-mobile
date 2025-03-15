package com.faturapay.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faturapay.data.model.Invoice
import com.faturapay.ui.theme.*
import com.faturapay.viewmodel.InvoiceViewModel
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddInvoiceDialog(viewModel: InvoiceViewModel = viewModel(), onDismiss: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = LightBackground,
        shape = RoundedCornerShape(20.dp),
        title = {
            Text(
                text = "Yeni Fatura Ekle",
                color = DarkGray,
                style = MaterialTheme.typography.titleLarge
            )
        },
        text = {
            Column(modifier = Modifier.padding(8.dp)) {
                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
                        if (showError) showError = false
                    },
                    label = { Text("Fatura Başlığı") },
                    isError = showError && title.isBlank(),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = amount,
                    onValueChange = {
                        amount = it
                        if (showError) showError = false
                    },
                    label = { Text("Tutar (TL)") },
                    isError = showError && amount.toDoubleOrNull() == null,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (title.isNotBlank() && amount.toDoubleOrNull() != null) {
                        val newInvoice = Invoice(
                            id = (0..1000).random(),
                            title = title,
                            amount = amount.toDouble(),
                            dueDate = Date(),
                            isPaid = false
                        )
                        viewModel.addInvoice(newInvoice)
                        onDismiss()
                    } else {
                        showError = true
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = AccentColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Ekle", color = White)
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("İptal", color = DarkGray)
            }
        }
    )
}
