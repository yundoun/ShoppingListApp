package com.example.shoppinglistapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {

    // 뷰 모델 안의 상태를 State 머신이 관리해주는 것

    private val _location = mutableStateOf<LocationData?>(null)
    val location : State<LocationData?> = _location

    fun updateLocation(locationData: LocationData) {
        _location.value = locationData
    }



}