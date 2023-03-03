package com.otaku.clones.cryptoapp.features.coin.domain.model

import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDto

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        isActive = isActive,
        rank = rank
    )
}