package com.otaku.clones.cryptoapp.features.coin.presentation.coin_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.TeamMember
import com.otaku.clones.cryptoapp.features.coin.presentation.coin_details.components.CoinTag
import com.otaku.clones.cryptoapp.features.coin.presentation.coin_details.components.TeamMemberListRow

@Composable
fun CoinDetailsScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {

    val state = viewModel.coinDetailState.value
    state.coin?.let { coin ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically,
                ) {
                    Text(
                        text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.weight(8f)
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
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = coin.description,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Tags",
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(15.dp))
                com.google.accompanist.flowlayout.FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    coin.tags.forEach { tag ->
                        CoinTag(tag = tag)
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Team Members",
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
            items(coin.team) { member: TeamMember ->
                TeamMemberListRow(
                    teamMember = member, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Divider()
            }
        }
    }


    if (state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }

    if (state.isLoading) {
        CircularProgressIndicator(
        )
    }
}
