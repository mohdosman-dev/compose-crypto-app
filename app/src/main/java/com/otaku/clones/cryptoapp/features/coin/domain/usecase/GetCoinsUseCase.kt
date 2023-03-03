package com.otaku.clones.cryptoapp.features.coin.domain.usecase

import android.util.Log
import com.otaku.clones.cryptoapp.common.Resource
import com.otaku.clones.cryptoapp.features.coin.domain.model.Coin
import com.otaku.clones.cryptoapp.features.coin.domain.model.toCoin
import com.otaku.clones.cryptoapp.features.coin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val TAG = "GetCoinsUseCase"

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading(null))
            val coins = repository.getCoins()
            emit(Resource.Success(
                coins.map { it.toCoin() }
            ))
        } catch (e: HttpException) {
            Log.e(TAG, "invoke: (HTTP) Error while fetching coins: $e")
            emit(Resource.Error(null, e.localizedMessage ?: "Unknown error occurred"))
        } catch (e: IOException) {
            Log.e(TAG, "invoke: (IO) Error while fetching coins: $e")
            emit(Resource.Error(null, e.localizedMessage ?: "Unknown error occurred"))
        } catch (e: java.lang.Exception) {
            Log.e(TAG, "invoke: (GENERAL) Error while fetching coins: $e")
            emit(Resource.Error(null, e.localizedMessage ?: "Unknown error occurred"))
        }
    }
}