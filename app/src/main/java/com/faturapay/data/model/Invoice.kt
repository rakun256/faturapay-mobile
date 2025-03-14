package com.faturapay.data.model

import java.util.Date

data class Invoice(
    val id: Int,
    val title: String,
    val amount: Double,
    val dueDate: Date,
    val isPaid: Boolean
)
