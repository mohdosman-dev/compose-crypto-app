package com.otaku.clones.cryptoapp.features.coin.domain.repository

import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDetailDto
import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDto

interface CoinRepository {
    @Throws
    suspend fun getCoins(): List<CoinDto>

    @Throws
    suspend fun getCoinDetails(id: String): CoinDetailDto
}