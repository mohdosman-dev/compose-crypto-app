package com.otaku.clones.cryptoapp.features.coin.presentation.coin_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otaku.clones.cryptoapp.features.coin.data.remote.dto.TeamMember

@Composable
fun TeamMemberListRow(
    modifier: Modifier = Modifier,
    teamMember: TeamMember,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
        )
    }
}

@Preview(name = "TeamMemberListRow")
@Composable
private fun PreviewTeamMemberListRow() {
    TeamMemberListRow(
        teamMember = TeamMember(
            id = "1",
            name = "Mohammed Osman",
            position = "Developer @ VIANEOS"
        )
    )
}