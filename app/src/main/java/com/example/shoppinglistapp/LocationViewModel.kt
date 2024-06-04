package com.example.shoppinglistapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {

    // 뷰 모델 안의 상태를 State 머신이 관리해주는 것

    private val _location = mutableStateOf<LocationData?>(null)
    val location : State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address : State<List<GeocodingResult>> = _address

    fun updateLocation(newLocation: LocationData){
        _location.value = newLocation
    }

    fun fetchAddress(latlng : String){
        try {
            viewModelScope.launch{
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    "AIzaSyAjWjEHTDTxyv1VlxQ-BKXhi3bjIbVGoRI"
                )
                _address.value = result.results
            }
        }catch(e:Exception) {
            Log.d("res1", "${e.cause} ${e.message}")
        }
    }

}