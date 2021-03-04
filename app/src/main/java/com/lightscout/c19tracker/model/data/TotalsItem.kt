package com.lightscout.c19tracker.model.data

data class TotalsItem(
    val confirmed: Int,
    val critical: Int,
    val deaths: Int,
    val lastChange: String,
    val lastUpdate: String,
    val recovered: Int
)