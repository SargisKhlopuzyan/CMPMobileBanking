package com.sargis.khlopuzyan.core.database.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransactionEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
)