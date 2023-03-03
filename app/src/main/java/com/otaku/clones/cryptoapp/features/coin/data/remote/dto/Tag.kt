package com.otaku.clones.cryptoapp.features.coin.data.remote.dto


import kotlinx.serialization.SerialName

data class Tag(
    @SerialName("coin_counter")
    val coinCounter: Int,
    @SerialName("ico_counter")
    val icoCounter: Int,
    val id: String,
    val name: String
)