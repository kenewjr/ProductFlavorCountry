package and5.abrar.mvvmcountry.network

import and5.abrar.mvvmcountry.model.GetCountryItemItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllCountry(): Call<List<GetCountryItemItem>>
}