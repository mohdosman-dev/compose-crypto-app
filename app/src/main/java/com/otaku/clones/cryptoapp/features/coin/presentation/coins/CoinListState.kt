package com.otaku.clones.cryptoapp.features.coin.presentation.coins

import com.otaku.clones.cryptoapp.features.coin.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
