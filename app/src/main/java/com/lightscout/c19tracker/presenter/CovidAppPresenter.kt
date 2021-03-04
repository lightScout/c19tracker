package com.lightscout.c19tracker.presenter

import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.model.data.Totals
import com.lightscout.c19tracker.model.network.APIRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidAppPresenter(val appView: CovidAppContract.AppView): CovidAppContract.AppPresenter {

    private val apiRetrofit = APIRetrofit()

    override fun getWorldCovidResults() {
        Thread{
            apiRetrofit.getLastTotals()
                .enqueue(object: Callback<Totals> {
                    override fun onFailure(call: Call<Totals>, t: Throwable){
                        appView.displayError("An error occurred: ${t.localizedMessage}")
                    }

                    override fun onResponse(call: Call<Totals>, response: Response<Totals>){
                        response.body()?.let {

                                appView.displayWorldResults(it)
                        } ?: appView.displayError("Response was null.")
                    }
                })
        }.start()
    }

    override fun getCountryCovidResult(country: String) {
        Thread{
            apiRetrofit.getDataFromCountry(country)
                .enqueue(object: Callback<List<CountryResult>>{
                    override fun onFailure(call: Call<List<CountryResult>>, t: Throwable){
                        appView.displayError("An error occurred: ${t.localizedMessage}")
                    }

                    override fun onResponse(
                        call: Call<List<CountryResult>>,
                        response: Response<List<CountryResult>>
                    ){
                        response.body()?.let {
                            if (it.isNotEmpty())
                                appView.displayCountryResults(it)
                            else
                                appView.displayError("No results found.")
                        } ?: appView.displayError("Response was null.")
                    }
                })
        }.start()
    }


}