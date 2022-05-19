package and5.abrar.mvvmcountry.viewmodel

import and5.abrar.mvvmcountry.model.GetCountryItemItem
import and5.abrar.mvvmcountry.network.ApiClient
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCountry:ViewModel() {
    lateinit var liveDataCountry:  MutableLiveData<List<GetCountryItemItem>>

    init {
        liveDataCountry = MutableLiveData()
    }

    fun getLivedataCountry (): MutableLiveData<List<GetCountryItemItem>> {
        return  liveDataCountry
    }

    fun getApiCountry(){
        ApiClient.instance.getAllCountry()
            .enqueue(object : Callback<List<GetCountryItemItem>> {
                override fun onResponse(
                    call: Call<List<GetCountryItemItem>>,
                    response: Response<List<GetCountryItemItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCountry.postValue(response.body())
                    }else{
                        liveDataCountry.postValue(null)
                    }
                }
                override fun onFailure(call: Call<List<GetCountryItemItem>>, t: Throwable) {
                    liveDataCountry.postValue(null)
                }

            })
    }
}