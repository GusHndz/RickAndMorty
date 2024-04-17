package mx.com.rifat.rickandmorty.core.common

import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject

object SuccessManagement {

    private const val TAG = "Response"
    fun <T> onSuccess(response: T): T {
        try {
            val result = JSONObject(Gson().toJson(response))

            Log.i(TAG, "Result Service -> $result")
        } catch (ex: Exception){
            Log.e(TAG, "-------- <Error Exception JSON> --------")
            Log.e(TAG, "<Message>: ${ex.message}")
            Log.e(TAG, "<Cause>: ${ex.cause}")
            Log.e(TAG, "-------- <Error Exception JSON> --------")
        }

        return response
    }
}