package com.otaku.clones.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.otaku.clones.cryptoapp.common.Constants.COIN_ID_PARAM_KEY
import com.otaku.clones.cryptoapp.features.coin.presentation.CoinRoutes
import com.otaku.clones.cryptoapp.features.coin.presentation.coin_details.CoinDetailsScreen
import com.otaku.clones.cryptoapp.features.coin.presentation.coins.CoinListScreen
import com.otaku.clones.cryptoapp.presentation.ui.theme.CryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = CoinRoutes.CoinListScreen.route
                    ) {
                        composable(CoinRoutes.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            CoinRoutes.CoinDetailScreen.route
                                    + "?$COIN_ID_PARAM_KEY={$COIN_ID_PARAM_KEY}"
                        ) {
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}
