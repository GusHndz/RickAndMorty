package mx.com.rifat.rickandmorty.core.repository

import android.content.Context
import android.util.Log
import kotlinx.coroutines.coroutineScope
import mx.com.rifat.rickandmorty.core.common.ResponseManagement
import mx.com.rifat.rickandmorty.core.data.ApiError
import mx.com.rifat.rickandmorty.core.repository.api.ApiRetrofit
import okio.IOException

class RepositoryConnection {

    companion object {
        const val TAG = "Retrofit"
    }

    suspend inline fun <reified T> apiRepository(
        url: String,
        responseService: (Pair<T?, ApiError?>) -> Unit,
        entityRequest: Any? = null,
    ) {
        val apiRetrofit = RetrofitService.retrofitHelper().create(ApiRetrofit::class.java)

        try {
            val response = coroutineScope  {
                entityRequest?.let { request ->
                    apiRetrofit.postServiceCoroutine(
                        url = url,
                        entity = request
                    )
                } ?: run {
                    apiRetrofit.getServiceCoroutine(
                        url = url
                    )
                }
            }
            responseService(ResponseManagement().responseService(response))
        } catch (e: IOException) {
            // Handle network-related errors
            Log.e(TAG, "-------- <Error Exception> --------")
            Log.e(TAG, "<Message>: ${e.message}")
            Log.e(TAG, "<Cause>: ${e.cause}")
            Log.e(TAG, "-------- <Error Exception> --------")

            responseService(
                Pair(
                    null, ApiError(
                        errorCode = "",
                        message = "Error de comunicaciones"
                    )
                )
            )
        }
    }
}