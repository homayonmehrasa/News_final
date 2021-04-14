package com.example.news

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

  @Headers("X-Api-Key: fe1ccf1152194d6f863661f1ca719c8b","Authorization: bearer fe1ccf1152194d6f863661f1ca719c8b")
  @GET ("top-headlines?apiKey=fe1ccf1152194d6f863661f1ca719c8b")
  fun getItem (@Query ("country" ) country : String="us", @Query("apiKey")apiKey:String = "fe1ccf1152194d6f863661f1ca719c8b"):Call<MyItem>


}