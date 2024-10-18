package com.example.retrofitpractise

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitpractise.data.JsonData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartsViewModel(
    private val repo: Repo
) : ViewModel() {
    var carts = MutableLiveData<JsonData>()
    var isLoading = MutableLiveData<Boolean>(false)
    init {
        getCarts()
    }
    private fun getCarts(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repo.getAllCartsFromAPI()
            if ( response.isSuccessful ){
                isLoading.postValue(true)
                carts.postValue(response.body())
            }
            isLoading.postValue(false)

        }
    }
}