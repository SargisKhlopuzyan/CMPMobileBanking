package com.sargis.khlopuzyan.core.network.api

import com.sargis.khlopuzyan.core.domain.DataError
import com.sargis.khlopuzyan.core.network.dto.TransactionsResponseDto
import com.sargis.khlopuzyan.core.network.util.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import com.sargis.khlopuzyan.core.domain.Result

class KtorRemoteTransactionsDataSource(
    private val httpClient: HttpClient
) : RemoteTransactionsDataSource {
    override suspend fun getTransactions(): Result<TransactionsResponseDto, DataError.Remote> {
        return safeCall<TransactionsResponseDto> {
            // https://api.themoviedb.org/3/search/movie?query=q
            httpClient.get("3/search/movie") {
//                parameter("query", q)
            }.body()
        }
    }
}