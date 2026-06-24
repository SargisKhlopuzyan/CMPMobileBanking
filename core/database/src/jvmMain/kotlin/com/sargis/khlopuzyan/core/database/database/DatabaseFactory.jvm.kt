package com.sargis.khlopuzyan.core.database.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual class DatabaseFactory {

    actual fun create(): RoomDatabase.Builder<TransactionsDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataPath = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "Transactions")
            os.contains("mac") -> File(userHome, "/Library/Application Support/Transactions")
            else -> File(System.getProperty(userHome), "/.local/share/Transactions")
        }

        if (!appDataPath.exists()) {
            appDataPath.mkdirs()
        }

        val dbFile = File(appDataPath, TransactionsDatabase.DB_NAME)

        return Room.databaseBuilder(dbFile.absolutePath)
    }
}