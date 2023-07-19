package com.example.parkingappnet.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkingappnet.data.model.retrofit.ItemPatent
import com.example.parkingappnet.domain.PatentEntranceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentIngresoViewModel@Inject constructor(
    val datapatent: PatentEntranceRepository
) : ViewModel() { var resultEnterRepo = MutableLiveData<ItemPatent>()

    fun onClickEntrancePatent(newEntrance: ItemPatent) {
         viewModelScope.launch(Dispatchers.IO) {
             val response = datapatent.newPatent(newEntrance)
             resultEnterRepo.postValue(newEntrance)
                if(response != null) println("DATA ENTRANCE IS RIGHT"+ datapatent.newPatent(newEntrance).toString())
                else println("DATA ENTRANCE IS WRONG")
         }
    }
}


