package mx.com.rifat.rickandmorty.core.common

import mx.com.rifat.rickandmorty.core.data.ApiError
import retrofit2.Response

interface RetrofitManagement {

    fun <T> responseService(response: Response<Any>): Pair<T?, ApiError?>
}