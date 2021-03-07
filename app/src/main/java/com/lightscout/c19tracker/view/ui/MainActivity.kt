package com.lightscout.c19tracker.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lightscout.c19tracker.R
import com.lightscout.c19tracker.databinding.ActivityMainBinding
import com.lightscout.c19tracker.model.data.CountryResult
import com.lightscout.c19tracker.model.data.Totals
import com.lightscout.c19tracker.presenter.CovidAppContract
import com.lightscout.c19tracker.presenter.CovidAppPresenter


class MainActivity : AppCompatActivity(), CovidAppContract.AppView {


    private lateinit var presenter: CovidAppPresenter

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CovidAppPresenter(this)
        presenter.getWorldCovidResults()


    }

    override fun displayError(errorMessage: String) {
        Snackbar.make(binding.root,"An error occurred: $errorMessage", Snackbar.LENGTH_SHORT)
    }

    override fun displayWorldResults(worldResult: Totals) {
        runOnUiThread {

            binding.covidConfirmedTextview.text =
                getString(R.string.latest_confirmed_world_total_value, worldResult[0].recovered.toString())
            binding.covidRecoveredTextview.text = getString(R.string.latest_recovered_world_total_value, worldResult[0].recovered.toString())
        }

    }

    override fun displayCountryResults(countryResults: List<CountryResult>) {
        TODO("Not yet implemented")
    }

}