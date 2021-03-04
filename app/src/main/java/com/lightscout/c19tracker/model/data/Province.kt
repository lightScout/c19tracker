package com.lightscout.c19tracker.model.data

data class Province(
    val active: Int,
    val confirmed: Int,
    val deaths: Int,
    val province: String,
    val recovered: Int
)