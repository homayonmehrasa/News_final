package com.example.news

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun getClient () : Retrofit {
        val loggingInterceptor= HttpLoggingInterceptor().apply { level= HttpLoggingInterceptor.Level.BODY }
        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
       return Retrofit.Builder()
            .baseUrl(" https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
               .client(client)
            .build()


    }


}