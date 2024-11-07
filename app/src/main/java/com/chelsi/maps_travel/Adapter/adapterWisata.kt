package com.chelsi.maps_travel.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chelsi.maps_travel.R
import com.chelsi.maps_travel.DetailWisata
import com.chelsi.maps_travel.model.ModelWisata

class adapterWisata(
    private var context: Context,
    private val wisataList: List<ModelWisata>
) : RecyclerView.Adapter<adapterWisata.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgWisata2)
        val nama: TextView = itemView.findViewById(R.id.wisata2)
        val lokasi: TextView = itemView.findViewById(R.id.lokasi2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wisata, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = wisataList[position]
        holder.img.setImageResource(currentItem.Img)
        holder.nama.text = currentItem.nama
        holder.lokasi.text = currentItem.lokasi

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailWisata::class.java)
            intent.putExtra("Img", currentItem.Img)
            intent.putExtra("nama", currentItem.nama)
            intent.putExtra("lokasi", currentItem.lokasi)
            intent.putExtra("des", currentItem.des)
            intent.putExtra("lat", currentItem.latitude) // Passing latitude
            intent.putExtra("lng", currentItem.longitude) // Passing longitude

            context.startActivity(intent)
        }
    }
}