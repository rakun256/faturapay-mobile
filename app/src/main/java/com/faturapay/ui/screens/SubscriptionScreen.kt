package com.faturapay.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faturapay.ui.components.SubscriptionItem
import com.faturapay.ui.components.AddSubscriptionDialog
import com.faturapay.ui.components.EditSubscriptionDialog
import com.faturapay.viewmodel.SubscriptionViewModel
import com.faturapay.ui.theme.AccentColor
import com.faturapay.data.model.Subscription

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionScreen(viewModel: SubscriptionViewModel = viewModel()) {
    val subscriptions by viewModel.subscriptions.observeAsState(emptyList())
    var showAddDialog by remember { mutableStateOf(false) }
    var subscriptionToEdit by remember { mutableStateOf<Subscription?>(null) }
    var subscriptionToDelete by remember { mutableStateOf<Subscription?>(null) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = AccentColor,
                shape = RoundedCornerShape(50)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Abonelik Ekle", tint = MaterialTheme.colorScheme.onPrimary)
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
                items(subscriptions) { subscription ->  // ✅ `it` yerine `subscription` ismi açıkça yazıldı
                    SubscriptionItem(
                        subscription = subscription,
                        onEdit = { subscriptionToEdit = subscription }, // ✅ Doğru şekilde çağrıldı
                        onDelete = { subscriptionToDelete = subscription } // ✅ Doğru şekilde çağrıldı
                    )
                }
            }
        }
    }

    // **Abonelik Ekleme Modali**
    if (showAddDialog) {
        AddSubscriptionDialog(onDismiss = { showAddDialog = false }) { newSubscription ->
            viewModel.addSubscription(newSubscription)
            showAddDialog = false
        }
    }

    // **Abonelik Düzenleme Modali**
    subscriptionToEdit?.let { selectedSubscription ->
        EditSubscriptionDialog(
            subscription = selectedSubscription,
            onDismiss = { subscriptionToEdit = null },
            onSave = { updatedSubscription ->
                viewModel.updateSubscription(updatedSubscription)
                subscriptionToEdit = null
            }
        )
    }

    // **Abonelik Silme Onayı**
    subscriptionToDelete?.let { selectedSubscription ->
        AlertDialog(
            onDismissRequest = { subscriptionToDelete = null },
            title = { Text("Aboneliği Sil") },
            text = { Text("Bu aboneliği silmek istediğinizden emin misiniz?") },
            confirmButton = {
                Button(onClick = {
                    viewModel.deleteSubscription(selectedSubscription)
                    subscriptionToDelete = null
                }) {
                    Text("Evet")
                }
            },
            dismissButton = {
                TextButton(onClick = { subscriptionToDelete = null }) { Text("İptal") }
            }
        )
    }
}
