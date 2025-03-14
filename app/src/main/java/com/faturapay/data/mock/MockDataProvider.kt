package com.faturapay.data.mock

import com.faturapay.data.model.Invoice
import com.faturapay.data.model.Subscription
import com.faturapay.data.model.User
import java.util.*

object MockDataProvider {

    fun getMockUser(): User {
        return User(
            id = 1,
            name = "Emre Uslu",
            email = "emre@example.com",
            password = "ecememre28"
        )
    }

    fun getMockInvoices(): List<Invoice> {
        return listOf(
            Invoice(1, "Elektrik Faturası", 350.0, Date(2025, 3, 20), false),
            Invoice(2, "Su Faturası", 120.5, Date(2025, 3, 18), true),
            Invoice(3, "İnternet Faturası", 180.0, Date(2025, 3, 25), false)
        )
    }

    fun getMockSubscriptions(): List<Subscription> {
        return listOf(
            Subscription(1, "Netflix", 99.99, Date(2025, 3, 30), true),
            Subscription(2, "Spotify", 49.99, Date(2025, 3, 15), true),
            Subscription(3, "Amazon Prime", 79.99, Date(2025, 3, 22), false)
        )
    }
}
