package mx.com.rifat.rickandmorty.core.common

import com.google.gson.Gson
import mx.com.rifat.rickandmorty.core.data.ApiError
import retrofit2.Response

object ErrorManagement {
    fun getErrorApi(response: Response<Any>): ApiError {
        val errorBody = response.errorBody()?.string()

        return if (!errorBody.isNullOrBlank()) {
           Gson().fromJson(errorBody, ApiError::class.java)
        } else {
            ApiError(
                errorCode = "",
                message = "Unknown error"
            )
        }
    }
}