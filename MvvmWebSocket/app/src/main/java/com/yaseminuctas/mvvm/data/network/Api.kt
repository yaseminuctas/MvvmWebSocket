package com.yaseminuctas.mvvm.data.network
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.http.GET
import com.yaseminuctas.mvvm.data.model.MockData
import com.yaseminuctas.mvvm.util.Const
import com.yaseminuctas.mvvm.util.Const.BASE_URL
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface Api {

    @GET("emredirican/mock-api/db")
    fun getData(): Deferred<Response<MockData>>

    companion object{
        operator fun invoke() : Api {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(Const.BASE_URL)
                .build()
                .create(Api::class.java)
        }
    }
}