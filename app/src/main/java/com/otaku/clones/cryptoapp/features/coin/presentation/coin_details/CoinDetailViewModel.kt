package com.otaku.clones.cryptoapp.features.coin.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otaku.clones.cryptoapp.common.Constants.COIN_ID_PARAM_KEY
import com.otaku.clones.cryptoapp.common.Resource
import com.otaku.clones.cryptoapp.features.coin.domain.usecase.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _coinState = mutableStateOf(CoinDetailState())
    val coinDetailState: State<CoinDetailState> = _coinState

    init {
        getCoinDetail()
    }

    private fun getCoinDetail() {
        savedStateHandle.get<String>(COIN_ID_PARAM_KEY)?.let { coinId ->
            getCoinDetailUseCase(coinId).onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _coinState.value = CoinDetailState(isLoading = true)
                    }
                    is Resource.Success -> {
                        _coinState.value = CoinDetailState(coin = result.data)
                    }
                    is Resource.Error -> {
                        _coinState.value =
                            CoinDetailState(error = result.message ?: "Unknown Error Occurred!")
                    }
                }
            }
                .launchIn(viewModelScope)
        }

    }
}