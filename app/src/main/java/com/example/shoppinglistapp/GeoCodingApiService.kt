package com.example.shoppinglistapp

import retrofit2.http.GET
import retrofit2.http.Query

interface GeoCodingApiService {

    @GET("maps/api/geocode/json")
    suspend fun getAddressFromCoordinates(
        @Query("latlngq") latlng: String,
        @Query("key") apiKey : String
    ): GeocodingResponse // 기존에 구축했던 데이터 클래스
}