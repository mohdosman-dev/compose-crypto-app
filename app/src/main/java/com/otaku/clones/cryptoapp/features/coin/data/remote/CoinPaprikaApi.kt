package com.otaku.clones.cryptoapp.features.coin.data.remote

import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDetailDto
import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{id}")
    suspend fun getCoinDetails(@Path("id") id: String): CoinDetailDto
}