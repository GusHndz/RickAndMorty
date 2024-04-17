package mx.com.rifat.rickandmorty.core.repository.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiRetrofit {

    @GET("{url}")
    suspend fun getServiceCoroutine(
        @Path(value = "url", encoded = true) url: String
    ): Response<Any>

    @POST("{url}")
    suspend fun postServiceCoroutine(
        @Path(value = "url", encoded = true) url: String,
        @Body entity: Any
    ): Response<Any>
}