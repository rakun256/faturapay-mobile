package com.faturapay.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp // Eksik import eklendi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState // Eksik import eklendi
import androidx.compose.ui.Alignment
import com.faturapay.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = viewModel()) {
    val darkModeEnabled by viewModel.darkModeEnabled.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Ayarlar", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                checked = darkModeEnabled,
                onCheckedChange = { viewModel.toggleDarkMode() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Karanlık Mod")
        }
    }
}
