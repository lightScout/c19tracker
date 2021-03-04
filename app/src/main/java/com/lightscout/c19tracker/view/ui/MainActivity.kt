package com.lightscout.c19tracker.view.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lightscout.c19tracker.R
import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.model.data.Totals
import com.lightscout.c19tracker.model.network.APIRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    private val apiRetrofit : APIRetrofit = APIRetrofit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            apiRetrofit.getDataFromCountry("Portugal").enqueue(object : Callback<List<CountryResult>> {
                override fun onResponse(call: Call<List<CountryResult>>, response: Response<List<CountryResult>>) {
                    response.body()?.let {
                        Log.d("TAG_J", "${it[0].country}")
                    }
                }

                override fun onFailure(call: Call<List<CountryResult>>, t: Throwable) {
                    Log.d("TAG_J", "An error occurred. ${t.localizedMessage}")
                }
            }
            )
        }.start()

        Thread{
            apiRetrofit.getLastTotals().enqueue(object : Callback<Totals> {
                override fun onResponse(call: Call<Totals>, response: Response<Totals>) {
                    response.body()?.let {
                        Log.d("TAG_J", "${it[0]}")
                    }
                }

                override fun onFailure(call: Call<Totals>, t: Throwable) {
                    Log.d("TAG_J", "An error occurred. ${t.localizedMessage}")
                }
            })
        }.start()

    }

}