package com.faturapay.data.model

import java.util.Date

data class Subscription(
    val id: Int,
    val serviceName: String,
    val amount: Double,
    val renewalDate: Date,
    val isActive: Boolean
)
