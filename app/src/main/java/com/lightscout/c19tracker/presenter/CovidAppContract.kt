package com.lightscout.c19tracker.presenter

import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.model.data.Totals

interface CovidAppContract {

    interface AppPresenter{
        fun getWorldCovidResults()
        fun getCountryCovidResult(country: String)
    }

    interface AppView{
        fun displayError(errorMessage: String)
        fun displayWorldResults(worldResult: Totals)
        fun displayCountryResults(countryResults: List<CountryResult>)
    }

}