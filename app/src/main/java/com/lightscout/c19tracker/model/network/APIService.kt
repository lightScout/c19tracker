package com.lightscout.c19tracker.model.network

import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.model.data.Totals
import com.lightscout.c19tracker.model.data.TotalsItem
import com.lightscout.c19tracker.util.Constants.Companion.API_HOST
import com.lightscout.c19tracker.util.Constants.Companion.API_KEY
import com.lightscout.c19tracker.util.Constants.Companion.PATH_BY_COUNTRY_NAME
import com.lightscout.c19tracker.util.Constants.Companion.PATH_DAILY_RESULT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {


    @Headers(API_KEY, API_HOST)
    @GET(PATH_BY_COUNTRY_NAME)
    fun getDailyReportByCountryName(@Query("date") date: String, @Query("name") name: String, @Query("format") format: String): Call<List<CountryResult>>

    @Headers(API_KEY, API_HOST)
    @GET(PATH_DAILY_RESULT)
    fun getLatestTotals(): Call<Totals>


}