package com.sargis.khlopuzyan.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [TransactionEntity::class],
    version = 1,
    //    exportSchema = false
)
@TypeConverters(
    StringListTypeConverter::class
)
abstract class TransactionsDatabase : RoomDatabase() {

    abstract val transactionDao: TransactionDao

    companion object {
        const val DB_NAME = "transactions.db"
    }
}