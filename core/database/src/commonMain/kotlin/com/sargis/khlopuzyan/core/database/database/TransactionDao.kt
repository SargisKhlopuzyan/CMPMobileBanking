package com.sargis.khlopuzyan.core.database.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Upsert
    suspend fun upsert(movie: TransactionEntity)

    @Query("SELECT * FROM TransactionEntity")
    fun observeTransactions(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM TransactionEntity WHERE id = :id")
    suspend fun getTransaction(id: String): TransactionEntity?

    @Query("DELETE FROM TransactionEntity WHERE id = :id")
    suspend fun deleteTransaction(id: String): Int
}