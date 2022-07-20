package com.example.formulaapp.network

import com.example.formulaapp.model.Drivers
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface RankingClient {
    @Headers(
        "X-RapidAPI-Key:" + "",
        "X-RapidAPI-Host:" + "f1-live-motorsport-data.p.rapidapi.com"
    )
    @GET("/drivers/standings/2020")
    fun getDriversRanking(): Single<Drivers>
}