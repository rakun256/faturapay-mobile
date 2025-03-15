package com.faturapay.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faturapay.data.model.Subscription
import com.faturapay.ui.theme.LightPrimary

@Composable
fun DashboardSubscriptionItem(subscription: Subscription) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = LightPrimary)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = subscription.serviceName, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Ücret: ${subscription.amount} TL", style = MaterialTheme.typography.bodySmall)
        }
    }
}

