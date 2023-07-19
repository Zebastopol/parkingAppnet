package com.example.parkingappnet.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parkingappnet.databinding.ActivitySalidaVehiculoBinding

class SalidaVehiculoActivity : AppCompatActivity() {

    lateinit var binding: ActivitySalidaVehiculoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalidaVehiculoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
//MÉTODO PARA RECUPERAR LA HORA Y FECHA DE INGRESO
// Y GENERAR UNA HORA Y FECHA DE SALIDA

}