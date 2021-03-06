package com.lightscout.c19tracker.model.network

import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.model.data.Totals
import com.lightscout.c19tracker.util.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIRetrofit {

    private  var apiService  = createAPIService(createRetrofit())


    private fun createRetrofit() : Retrofit{
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createAPIService(retrofit : Retrofit): APIService{
        return retrofit.create(APIService::class.java)
    }

    fun getDataFromCountry(countryName:String): Call<List<CountryResult>>
        = apiService.getDailyReportByCountryName("2021-04-04",countryName,"json")

    fun getLastTotals(): Call<Totals> = apiService.getLatestTotals()


}

