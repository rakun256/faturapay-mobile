package com.faturapay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.faturapay.ui.screens.*
import com.faturapay.ui.theme.FaturaPayTheme
import com.faturapay.viewmodel.InvoiceViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FaturaPayTheme {
                val navController = rememberNavController()
                AppContent(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(navController: NavHostController) {
    val currentRoute by navController.currentBackStackEntryAsState()
    val route = currentRoute?.destination?.route ?: "dashboard"

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(getScreenTitle(route)) }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(navController)
        }
    }
}

// **Sayfa başlıklarını belirleyen fonksiyon**
fun getScreenTitle(route: String): String {
    return when (route) {
        "dashboard" -> "FaturaPay"
        "invoices" -> "Faturalar"
        "payment" -> "Ödeme"
        "settings" -> "Ayarlar"
        "subscriptions" -> "Abonelikler"
        else -> "FaturaPay"
    }
}

// **Navigasyon Grafiği**
@Composable
fun NavigationGraph(navController: NavHostController) {
    val invoiceViewModel: InvoiceViewModel = viewModel() // Create or get the ViewModel instance
    NavHost(navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController) }
        composable("invoices") { InvoiceListScreen() }
        composable("payment") { PaymentScreen() }
        composable("settings") { SettingsScreen() }
        composable("subscriptions") { SubscriptionScreen() }
    }
}

// **Alt Navigasyon Barı**
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Dashboard") },
            selected = currentRoute == "dashboard",
            onClick = {
                navController.navigate("dashboard") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true }
            }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Faturalar") },
            selected = currentRoute == "invoices",
            onClick = {
                navController.navigate("invoices") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true }
            }
        )

        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Abonelikler")},
            selected = currentRoute == "subscriptions",
            onClick = {
                navController.navigate("subscriptions") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true }
            }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Ödeme") },
            selected = currentRoute == "payment",
            onClick = {
                navController.navigate("payment") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true }
            }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Ayarlar") },
            selected = currentRoute == "settings",
            onClick = {
                navController.navigate("settings") {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true }
            }
        )
    }
}

// **Uygulama Önizleme**
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    FaturaPayTheme {
        val navController = rememberNavController()
        AppContent(navController)
    }
}
