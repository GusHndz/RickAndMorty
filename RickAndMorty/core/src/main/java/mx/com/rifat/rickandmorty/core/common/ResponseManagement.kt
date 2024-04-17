package mx.com.rifat.rickandmorty.core.common

import mx.com.rifat.rickandmorty.core.data.ApiError
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
class ResponseManagement : RetrofitManagement {
    override fun <T> responseService(response: Response<Any>): Pair<T?, ApiError?> {
        return if (response.isSuccessful) {
            response.body()?.let { entity ->
                Pair(
                    SuccessManagement.onSuccess(entity) as T,
                    null
                )
            } ?: run {
                Pair(
                    null,
                    ApiError(
                        errorCode = "",
                        message = "Empty response"
                    )
                )
            }
        } else {
            Pair(
                null,
                ErrorManagement.getErrorApi(response)
            )
        }
    }
}