package com.lightscout.c19tracker.model.network

import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.util.Constants.Companion.API_HOST
import com.lightscout.c19tracker.util.Constants.Companion.API_KEY
import com.lightscout.c19tracker.util.Constants.Companion.PATH
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CountryAPIService {


    @Headers(API_KEY, API_HOST)

    @GET(PATH)
    fun getCountryResult(@Query("date") date: String, @Query("name") name: String, @Query("format") format: String): Call<List<CountryResult>>


}