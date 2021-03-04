package com.lightscout.c19tracker.model.network

import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.util.Constants.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryAPIRetrofit {

    private  var countryAPIService : CountryAPIService = createAPIService(createRetrofit())


    private fun createRetrofit() : Retrofit{
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createAPIService(retrofit : Retrofit): CountryAPIService{
        return retrofit.create(CountryAPIService::class.java)
    }

    fun getDataFromCountry(countryName:String): Call<List<CountryResult>>
        = countryAPIService.getCountryResult("2021-04-04",countryName,"json")




}

