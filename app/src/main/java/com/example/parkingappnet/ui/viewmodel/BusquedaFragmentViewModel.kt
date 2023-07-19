package com.example.parkingappnet.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkingappnet.data.model.retrofit.ListPatentResponse
import com.example.parkingappnet.domain.BusquedaPatentesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusquedaFragmentViewModel@Inject constructor(
    val dataPatents: BusquedaPatentesRepository): ViewModel() {
        var resultLoadRepo = MutableLiveData<List<ListPatentResponse>>()

    fun onClickBuscarPatent(patents: ListPatentResponse) {
            viewModelScope.launch(Dispatchers.IO) {
               val response = dataPatents.loadPatentList(patents)
               resultLoadRepo.postValue(listOf(patents))
                if(response != null) println("DATA PATENT LIST IS RIGHT"+ dataPatents.loadPatentList(patents).toString())
                else println("DATA PATENT LIST IS WRONG")
            }

    }
}

