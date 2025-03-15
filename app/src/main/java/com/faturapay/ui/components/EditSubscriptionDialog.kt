package com.faturapay.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faturapay.data.model.Subscription
import com.faturapay.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSubscriptionDialog(
    subscription: Subscription,
    onDismiss: () -> Unit,
    onSave: (Subscription) -> Unit
) {
    var name by remember { mutableStateOf(subscription.serviceName) }
    var price by remember { mutableStateOf(subscription.amount.toString()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = LightBackground,
        shape = RoundedCornerShape(20.dp),
        title = {
            Text(text = "Abonelik Düzenle", color = DarkGray)
        },
        text = {
            Column(modifier = Modifier.padding(8.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Abonelik Adı") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    label = { Text("Ücret (TL)") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotBlank() && price.toDoubleOrNull() != null) {
                        onSave(subscription.copy(serviceName = name, amount = price.toDouble()))
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = AccentColor)
            ) {
                Text("Kaydet", color = White)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("İptal", color = DarkGray) }
        }
    )
}
