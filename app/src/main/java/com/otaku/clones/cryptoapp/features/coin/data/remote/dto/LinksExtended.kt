package com.otaku.clones.cryptoapp.features.coin.data.remote.dto


import kotlinx.serialization.Serializable

data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)