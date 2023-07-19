package com.example.parkingappnet.ui.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import com.example.parkingappnet.data.model.retrofit.LoginModel
import com.example.parkingappnet.databinding.ActivityLoginBinding
import com.example.parkingappnet.ui.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer()
        //loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btnIngresar.setOnClickListener {

            var rutempresa = binding.txRut.editText?.text.toString() /*"22222222-2"*/
            var usuario = binding.txUser.editText?.text.toString()  /*"Demo"*/
            var pass = binding.txPass.editText?.text.toString()  /*"123456"*/

            loginViewModel.onUserValidator(usuarioModel = LoginModel(username = usuario, empresa = rutempresa, password = pass))

        }

    }
    private fun observer() {
        loginViewModel.resultLoginRepository.observe(this, Observer {
            binding.progBarLog.visibility = View.GONE
            if (it != null){
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Usuario no Registrado", Toast.LENGTH_LONG).show()
            }
        })


    }
}