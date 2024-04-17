package mx.com.rifat.rickandmorty.core.repository

import mx.com.rifat.rickandmorty.core.common.CoreUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {

    private val authInterceptor = Interceptor { chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(url)
            .build()

        chain.proceed(newRequest)
    }

    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val client =
        OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .connectTimeout(6000, TimeUnit.SECONDS)
            .readTimeout(6000, TimeUnit.SECONDS)
            .writeTimeout(6000, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)
            .build()

    fun retrofitHelper(url: String? = null): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url ?: CoreUtil.getBaseURL() )
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}