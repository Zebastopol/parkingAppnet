package com.example.parkingappnet.ui.view.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.parkingappnet.data.model.retrofit.ItemPatent
import com.example.parkingappnet.databinding.FragmentHomeIngresoBinding
import com.example.parkingappnet.ui.viewmodel.HomeFragmentIngresoViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class HomeFragmentIngreso : Fragment() {

    private val homeFragmentIngresoViewModel: HomeFragmentIngresoViewModel by viewModels()
    private var _binding: FragmentHomeIngresoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (_binding == null) {
            _binding = FragmentHomeIngresoBinding.inflate(inflater, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
        initButtonSaveData()

    }

    private fun initButtonSaveData() {
        binding.btnNewEntrance.setOnClickListener {
            generatePatentData()
            printTicket()
        }

    }

    private fun printTicket() {
        TODO("Not yet implemented")
    }

    private fun generatePatentData() {
        val currentDateTime = generateCurrentDateTime()
        val patent =  ItemPatent(
        idPatent = binding.edtHomeId.text.toString(),
        dateEntrance = currentDateTime.first,
        timeEntrance = currentDateTime.second,
        state = "") //"PENDIENTE" REVISAR PARÁMETRO "state"
        val sharedPreferences = requireActivity().getSharedPreferences("patent", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("idPatent", patent.idPatent)
        editor.putString("dateEntrance", patent.dateEntrance)
        editor.putString("timeEntrance", patent.timeEntrance)
        editor.putString("state", patent.state)
        editor.apply()
        Toast.makeText(requireContext(), "Patente generada", Toast.LENGTH_LONG).show()
        val intent = Intent(requireContext().applicationContext, BusquedaFragment::class.java)
        startActivity(intent)
        homeFragmentIngresoViewModel.onClickEntrancePatent(patent)

    }
    /*
    private fun get(dataPatent: ItemPatent) {
        val sharedPreferences = requireContext().getSharedPreferences(
            "com.example.parkingappnet",  "ParkingAppnet"  // Nombre de la aplicación-
        )
    }*/


    private fun generateCurrentDateTime(): Pair<String, String> {
        val calendar = Calendar.getInstance()
        var sdfDate = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        var currentDate = sdfDate.format(calendar.time)

        var sdfTime = SimpleDateFormat("HH:mm", Locale.US)
        var currentTime = sdfTime.format(calendar.time)

        return Pair(first=currentDate, second = currentTime)
    }

    private fun initObserver() {
        homeFragmentIngresoViewModel.resultEnterRepo.observe(viewLifecycleOwner, Observer {
            // IMPRIMIR TICKET SUNMI DE INGRESO
            if (it != null) {
                val intent = Intent(context, BusquedaFragment::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Patente no ingresada", Toast.LENGTH_LONG).show()
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
