package com.sargis.khlopuzyan.designsystem.unit

import kotlin.math.abs
import kotlin.math.roundToLong

fun Double.formatAsAmount(): String {
    val sign = if (this < 0) "-" else ""
    val rounded = (abs(this) * 100).roundToLong()
    val integerPart = rounded / 100
    val fractionalPart = (rounded % 100).toInt().toString().padStart(2, '0')

    return "$sign${formatIntegerPart(integerPart)}.$fractionalPart"
}

private fun formatIntegerPart(value: Long): String {
    val digits = value.toString()
    if (digits.length <= 3) return digits

    val groups = digits.reversed().chunked(3).map { it.reversed() }.reversed()
    return groups.joinToString(separator = ",")
}

