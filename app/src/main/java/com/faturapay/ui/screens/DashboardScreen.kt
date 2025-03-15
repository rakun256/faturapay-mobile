package com.faturapay.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.faturapay.data.model.Invoice
import com.faturapay.data.model.Subscription
import com.faturapay.ui.components.DashboardInvoiceItem
import com.faturapay.ui.components.DashboardSubscriptionItem
import com.faturapay.viewmodel.DashboardViewModel
import com.faturapay.viewmodel.SubscriptionViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: DashboardViewModel = viewModel(),
    subscriptionViewModel: SubscriptionViewModel = viewModel()
) {
    val invoices by viewModel.invoices.observeAsState(emptyList())
    val subscriptions by subscriptionViewModel.subscriptions.observeAsState(emptyList())

    val unpaidInvoices = invoices.filter { !it.isPaid }
    val paidInvoices = invoices.filter { it.isPaid }
    val overdueInvoices = invoices.filter { !it.isPaid && it.dueDate.before(Date()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // **Kullanıcı Bilgisi**
            Text(
                text = "Merhaba, Kullanıcı!",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Hesap Durumu: ${unpaidInvoices.size} ödenmemiş, ${overdueInvoices.size} gecikmiş fatura.",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        item {
            // **Özet Kartları**
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SummaryCard("Ödenmemiş", unpaidInvoices.size, MaterialTheme.colorScheme.primary, Modifier.weight(1f))
                SummaryCard("Gecikmiş", overdueInvoices.size, MaterialTheme.colorScheme.error, Modifier.weight(1f))
                SummaryCard("Ödenmiş", paidInvoices.size, MaterialTheme.colorScheme.secondary, Modifier.weight(1f))
            }
        }

        item {
            // **Son Faturalar Başlığı**
            Text(
                text = "Son Faturalar",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        }

        items(invoices.take(5)) { invoice: Invoice ->
            DashboardInvoiceItem(invoice)
        }

        item {
            // **Son Abonelikler Başlığı**
            Text(
                text = "Son Abonelikler",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        }

        items(subscriptions) { subscription: Subscription ->
            DashboardSubscriptionItem(subscription)
        }
    }
}

@Composable
fun SummaryCard(title: String, count: Int, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
            )
            Text(
                text = "$count",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
    }
}
