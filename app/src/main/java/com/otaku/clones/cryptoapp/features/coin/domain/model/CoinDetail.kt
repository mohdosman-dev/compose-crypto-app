package com.otaku.clones.cryptoapp.features.coin.domain.model

import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.CoinDetailDto
import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.TeamMember

data class CoinDetail(
    val description: String,
    val id: String,
    val isActive: Boolean,
    val logo: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val tags: List<String>,
    val team: List<TeamMember>,
    val type: String,
)

fun CoinDetailDto.toCoin(): CoinDetail {
    return CoinDetail(
        id = id,
        name = name,
        symbol = symbol,
        isActive = isActive,
        rank = rank,
        description = description,
        logo = logo,
        tags = tags.map { it.name },
        team = team,
        type = type
    )
}