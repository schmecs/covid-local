package com.rebeccablum.covidlocal.api

import com.rebeccablum.covidlocal.models.CurrentStateInfo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET(STATES_URL)
    suspend fun getCurrentStatesInfo(): List<CurrentStateInfo>

    companion object {

        private const val STATES_URL = "states/current.json"

        fun getApiService(): ApiService {
            val builder = OkHttpClient.Builder()

            builder.addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BASIC)
            )

            val client = builder.build()

            return Retrofit.Builder()
                .baseUrl("https://covidtracking.com/api/v1/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}