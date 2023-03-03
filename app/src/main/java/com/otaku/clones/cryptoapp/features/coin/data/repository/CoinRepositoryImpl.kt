package com.otaku.clones.cryptoapp.features.coin.data.repository

import com.otaku.clones.cryptoapp.features.coin.data.remote.CoinPaprikaApi
import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDetailDto
import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDto
import com.otaku.clones.cryptoapp.features.coin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetails(id: String): CoinDetailDto {
        return api.getCoinDetails(id)
    }
}