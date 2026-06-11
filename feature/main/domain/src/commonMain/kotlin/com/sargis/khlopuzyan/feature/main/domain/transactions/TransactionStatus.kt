package com.sargis.khlopuzyan.feature.main.domain.transactions

enum class TransactionStatus(val nameX : String) {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    REFUSED("Refused")
}