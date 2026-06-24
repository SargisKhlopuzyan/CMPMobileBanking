package com.sargis.khlopuzyan.core.database.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<TransactionsDatabase>
}