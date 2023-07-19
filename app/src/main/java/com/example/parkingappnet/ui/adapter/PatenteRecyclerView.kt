package com.example.parkingappnet.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingappnet.databinding.ItemPatentesBinding
import com.example.parkingappnet.data.model.retrofit.ListPatentResponse
import com.example.parkingappnet.ui.view.activity.SalidaVehiculoActivity

const val PATENTEID_MESSAGE = "com.example.parkingappnet.PATENTEID"

class PatenteRecyclerView(private val datos: List<ListPatentResponse>):RecyclerView.Adapter<PatenteRecyclerView.ViewHolder>() {

    class ViewHolder(val binding : ItemPatentesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPatentesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val patente = datos.get(position)
        //holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.context,R.anim.fade_transition))
        with(holder.binding){
        txtNumpatente.text = "Número Patente ${patente.patent}"
        txtFechaingreso.text = "Fecha ${patente.dateEntrance}"
        txtHoraingreso.text = "Hora ${patente.timeEntrance}"
        }
        /*holder.binding.root.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, SalidaVehiculoActivity::class.java).apply {
                putExtra(PATENTEID_MESSAGE,patente.patent)
            }
            it.context.startActivity(intent)

        })*/
    }

    override fun getItemCount(): Int {
        return datos.size
    }


}
