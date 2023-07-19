package com.example.parkingappnet.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parkingappnet.domain.LoginRepository
import com.example.parkingappnet.data.model.retrofit.LoginModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val dataLogin: LoginRepository
) :  ViewModel() {
    var resultLoginRepository = MutableLiveData<LoginModel>()

  fun onUserValidator(usuarioModel: LoginModel) {
     viewModelScope.launch {
       val response = dataLogin.validateLog(usuarioModel)
       resultLoginRepository.postValue(usuarioModel)
         if (response != null)println("DATA LOGIN VIEWMODEL" + dataLogin.validateLog(usuarioModel).toString())
         else    println("FALLO AL CARGAR DATA LOGIN VIEWMODEL")
     }
  }

}