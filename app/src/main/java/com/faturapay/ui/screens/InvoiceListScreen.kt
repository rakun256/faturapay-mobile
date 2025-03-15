package com.faturapay.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faturapay.data.model.Invoice
import com.faturapay.ui.components.InvoiceItem
import com.faturapay.ui.components.AddInvoiceDialog
import com.faturapay.ui.components.EditInvoiceDialog
import com.faturapay.viewmodel.InvoiceViewModel
import com.faturapay.ui.theme.AccentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvoiceListScreen(viewModel: InvoiceViewModel = viewModel()) {
    val invoices by viewModel.invoices.collectAsState(emptyList())

    var showAddDialog by remember { mutableStateOf(false) }
    var invoiceToEdit by remember { mutableStateOf<Invoice?>(null) }
    var invoiceToDelete by remember { mutableStateOf<Invoice?>(null) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = AccentColor,
                shape = RoundedCornerShape(50)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Fatura Ekle", tint = MaterialTheme.colorScheme.onPrimary)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            LazyColumn {
                items(invoices) { invoice: Invoice ->
                    InvoiceItem(
                        invoice = invoice,
                        onEdit = { invoiceToEdit = it },
                        onDelete = { invoiceToDelete = it }
                    )
                }
            }
        }
    }

    // 🔹 Fatura Ekleme Modali
    if (showAddDialog) {
        AddInvoiceDialog(viewModel = viewModel, onDismiss = { showAddDialog = false })
    }

    // 🔹 Fatura Düzenleme Modali
    invoiceToEdit?.let { invoice ->
        EditInvoiceDialog(
            invoice = invoice,
            onDismiss = { invoiceToEdit = null },
            onSave = { updatedInvoice ->
                viewModel.updateInvoice(updatedInvoice)
                invoiceToEdit = null
            }
        )
    }

    // 🔹 Fatura Silme Onayı
    invoiceToDelete?.let { invoice ->
        AlertDialog(
            onDismissRequest = { invoiceToDelete = null },
            title = { Text("Fatura Sil") },
            text = { Text("Bu faturayı silmek istediğinizden emin misiniz?") },
            confirmButton = {
                Button(onClick = {
                    viewModel.deleteInvoice(invoice)
                    invoiceToDelete = null
                }) {
                    Text("Evet")
                }
            },
            dismissButton = {
                TextButton(onClick = { invoiceToDelete = null }) { Text("İptal") }
            }
        )
    }
}
