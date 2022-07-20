package com.example.formulaapp.repository

import com.example.formulaapp.model.Drivers
import com.example.formulaapp.network.RankingClient
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DriverRepository @Inject constructor(
    private val rankingClient: RankingClient
) {
    fun getDriversRanking(): Single<Drivers> {
        return rankingClient.getDriversRanking()
            .subscribeOn(Schedulers.io())
    }
}