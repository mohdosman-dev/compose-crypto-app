package com.otaku.clones.cryptoapp.features.coin.presentation

sealed class CoinRoutes(val route: String) {
    object CoinListScreen : CoinRoutes("coins_screen")
    object CoinDetailScreen : CoinRoutes("coin_detail_screen")
}
