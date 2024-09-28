package com.sercan.yigit.weros_health_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _getSteps: MutableLiveData<Int?> = MutableLiveData<Int?>()
    var getStep: LiveData<Int?> = _getSteps

    private var _getHeartRate: MutableLiveData<Int?> = MutableLiveData<Int?>()
    var getHeartRate: LiveData<Int?> = _getHeartRate

    fun setSteps(steps: Int?) {
        _getSteps.value = steps
    }

    fun setHeartRate(heartRate: Int?) {
        _getHeartRate.value = heartRate
    }
}