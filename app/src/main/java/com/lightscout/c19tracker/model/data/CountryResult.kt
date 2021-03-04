package com.lightscout.c19tracker.model.data

data class CountryResult(
    val country: String,
    val date: String,
    val latitude: Double,
    val longitude: Double,
    val provinces: List<Province>
)