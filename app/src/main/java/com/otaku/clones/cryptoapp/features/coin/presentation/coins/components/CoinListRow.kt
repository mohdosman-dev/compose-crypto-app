package com.otaku.clones.cryptoapp.features.coin.presentation.coins.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otaku.clones.cryptoapp.features.coin.domain.model.Coin

@Composable
fun CoinListRow(
    onItemClick: (Coin) -> Unit,
    coin: Coin,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onItemClick(coin) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Ellipsis,
            color = if (coin.isActive) Color.Green else Color.Red,
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.align(CenterVertically)
        )
    }
}

@Preview(name = "CoinListRow")
@Composable
private fun PreviewCoinListRow() {
    CoinListRow(
        coin = Coin(
            id = "1",
            rank = 1,
            isActive = false,
            symbol = "\$",
            name = "USD"
        ),
        onItemClick = { _ -> }
    )
}