package com.example.formulaapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Drivers(
    @Json(name = "results")
    val results: List<Driver>
)

@JsonClass(generateAdapter = true)
data class Driver(
    @Json(name = "position")
    val position: Int?,
    @Json(name = "points")
    val points: String?,
    @Json(name = "driver_id")
    val driverId: Long?,
    @Json(name = "driver_name")
    val driverName: String?,
    @Json(name = "team_id")
    val teamId: Long?,
    @Json(name = "team_name")
    val teamName: String?,
    @Json(name = "nationality")
    val nationality: String?,
    @Json(name = "season")
    val season: Long?
)



