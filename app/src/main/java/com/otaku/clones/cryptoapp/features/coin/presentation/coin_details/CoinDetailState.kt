package com.otaku.clones.cryptoapp.features.coin.presentation.coin_details

import com.otaku.clones.cryptoapp.features.coin.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
