package com.otaku.clones.cryptoapp.features.coin.presentation.coins

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otaku.clones.cryptoapp.common.Resource
import com.otaku.clones.cryptoapp.features.coin.domain.usecase.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    private val _coinState = mutableStateOf(CoinListState())
    val coinState: State<CoinListState> = _coinState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _coinState.value = CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    _coinState.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _coinState.value =
                        CoinListState(error = result.message ?: "Unknown Error Occurred!")
                }
            }
        }
            .launchIn(viewModelScope)

    }
}