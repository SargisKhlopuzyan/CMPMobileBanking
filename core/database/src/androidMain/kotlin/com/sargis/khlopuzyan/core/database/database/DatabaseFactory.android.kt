package com.sargis.khlopuzyan.core.database.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<TransactionsDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(TransactionsDatabase.DB_NAME)
        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}