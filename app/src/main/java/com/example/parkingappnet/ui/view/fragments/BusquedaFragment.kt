package com.example.parkingappnet.ui.view.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import androidx.fragment.application.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parkingappnet.databinding.FragmentBusquedaBinding
import com.example.parkingappnet.ui.adapter.PatenteRecyclerView
import com.example.parkingappnet.ui.viewmodel.BusquedaFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
//import com.example.parkingappnet.ui.adapter.PatenteRecyclerView
//import com.example.parkingappnet.ui.viewmodel.BusquedaFragmentViewModel

@AndroidEntryPoint
class BusquedaFragment : Fragment(){

    private val busquedaFragmentViewModel: BusquedaFragmentViewModel by viewModels()
    private var _binding: FragmentBusquedaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (_binding == null) {
            _binding = FragmentBusquedaBinding.inflate(inflater, container, false)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        //val sharedDate = getSharedPreferences("EntranceDate", MODE_PRIVATE)
        //val editor = sharedDate.edit()
        val myRecyclerPatente = binding.myRecycler
        myRecyclerPatente.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.btnSearchPatent.setOnClickListener {
        //generatePatentData()
        }
    }

/*    private fun generatePatentData() {
        val sharedDate = getSharedPreferences("EntranceTime", MODE_PRIVATE)
        val sharedDateTime = "${sharedDate.getString("date", "")} ${sharedTime.getString("time", "")}"
        binding.txBuscaPatente.text = sharedDateTime
        //val sharedDate = getSharedPreferences("EntranceDate", MODE_PRIVATE)
        //val sharedTime = getSharedPreferences("EntranceTime", MODE_PRIVATE)
        //val sharedDateTime = "${sharedDate.getString("date", "")} ${sharedTime.getString("time", "")}"
        //binding.txtEntranceDateTime.text = sharedDateTime
        //val sharedDate = getSharedPreferences("EntranceDate", MODE_PRIVATE)
    }*/

    private fun initObserver(){
        busquedaFragmentViewModel.resultLoadRepo.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.myRecycler.adapter = PatenteRecyclerView(it)
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}