package com.lightscout.c19tracker.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lightscout.c19tracker.R
import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.model.network.CountryAPIRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val countryAPIRetrofit : CountryAPIRetrofit = CountryAPIRetrofit()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            countryAPIRetrofit.getDataFromCountry("Portugal").enqueue(object : Callback<List<CountryResult>> {
                override fun onResponse(call: Call<List<CountryResult>>, response: Response<List<CountryResult>>) {
                    response.body()?.let {
                        Log.d("TAG_J", "${it[0].country}")
                    }
                }

                override fun onFailure(call: Call<List<CountryResult>>, t: Throwable) {
                    Log.d("TAG_J", "An error occurred. ${t.localizedMessage}")
                }
            })
        }.start()
    }

}