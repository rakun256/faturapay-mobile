package com.faturapay.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faturapay.ui.theme.*
import com.faturapay.data.model.Subscription
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSubscriptionDialog(onDismiss: () -> Unit, onAddSubscription: (Subscription) -> Unit) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var renewalDate by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = LightBackground,
        shape = RoundedCornerShape(20.dp),
        title = {
            Text(
                text = "Yeni Abonelik Ekle",
                color = DarkPrimary,
                style = MaterialTheme.typography.titleLarge
            )
        },
        text = {
            Column(modifier = Modifier.padding(8.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Abonelik Adı") },
                    isError = showError && name.isBlank(),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    label = { Text("Ücret (TL)") },
                    isError = showError && price.toDoubleOrNull() == null,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = renewalDate,
                    onValueChange = { renewalDate = it },
                    label = { Text("Yenileme Tarihi (DD/MM/YYYY)") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotBlank() && price.toDoubleOrNull() != null) {
                        onAddSubscription(
                            Subscription(
                                id = (0..1000).random(),
                                serviceName = name,
                                amount = price.toDouble(),
                                renewalDate = Date(), // TODO: Date formatını düzenle
                                isActive = true
                            )
                        )
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
            TextButton(onClick = onDismiss) {
                Text("İptal", color = DarkPrimary)
            }
        }
    )
}
