package api

import Models.CityInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CityInfoApi {
    @GET("location/{cityName}")
    fun getCityInfo(@Path("cityName") cityName: String): Call<CityInfoResponse>
}
