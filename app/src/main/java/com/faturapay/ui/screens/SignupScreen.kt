package com.faturapay.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.faturapay.ui.theme.*
import com.faturapay.viewmodel.SignupViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController, viewModel: SignupViewModel = viewModel()) {
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Kayıt Ol", style = MaterialTheme.typography.headlineMedium, color = DarkPrimary)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.email.value ?: "",
            onValueChange = { viewModel.email.value = it },
            label = { Text("E-posta") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.password.value ?: "",
            onValueChange = { viewModel.password.value = it },
            label = { Text("Şifre") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = viewModel.confirmPassword.value ?: "",
            onValueChange = { viewModel.confirmPassword.value = it },
            label = { Text("Şifre Tekrar") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        if (errorMessage.isNotEmpty()) {
            Text(errorMessage, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.validateAndSignup()
                if (viewModel.isSignupSuccessful.value == true) {
                    navController.navigate("dashboard")
                } else {
                    errorMessage = "Hatalı giriş!"
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = AccentColor)
        ) {
            Text("Kayıt Ol", color = White)
        }
    }
}
