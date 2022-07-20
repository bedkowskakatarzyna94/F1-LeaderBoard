package com.example.formulaapp.ui.landing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.formulaapp.model.Driver
import com.example.formulaapp.repository.DriverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    driverRepository: DriverRepository
) : ViewModel() {
    private val _formulaDrivers = MutableLiveData<List<Driver>>()
    val formulaDrivers: LiveData<List<Driver>>
        get() = _formulaDrivers

    init{
        driverRepository.getDriversRanking()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({drivers -> _formulaDrivers.value = drivers.results}, {t->Timber.e(t)})
    }
}