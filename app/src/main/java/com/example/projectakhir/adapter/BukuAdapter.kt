package com.example.projectakhir.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.R
import com.example.projectakhir.model.Buku

class BukuAdapter(val context: Context): RecyclerView.Adapter<BukuAdapter.BukuViewHolder>(){

    private val buku: MutableList<Buku> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        return BukuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_buku, parent, false))
    }

    override fun onBindViewHolder(holder: BukuAdapter.BukuViewHolder, position: Int) {
        holder.binmodel(buku[position])
    }

    override fun getItemCount(): Int {
        return buku.size
    }
    fun setBuku(data: List<Buku>){
        buku.clear()
        buku.addAll(data)
        notifyDataSetChanged()
    }
    inner class BukuViewHolder(item: View): RecyclerView.ViewHolder(item){

        val txtJudulBuku: TextView = item.findViewById(R.id.tv_judul)
        val txtNamaPengarang: TextView = item.findViewById(R.id.tv_pengarang)
        val txtDeskripsi: TextView = item.findViewById(R.id.tv_deskripsi)
        val txtHarga: TextView = item.findViewById(R.id.tv_harga)
        val txtLokasi: TextView = item.findViewById(R.id.tv_lokasi)

        fun binmodel (buku: Buku){
            txtJudulBuku.text = buku.getJudulBuku()
            txtNamaPengarang.text = buku.getNamaPengerangBuku()
            txtDeskripsi.text = buku.getDeskripsiBuku()
            txtHarga.text = buku.getHarga()
            txtLokasi.text = buku.getAlamatToko()
        }
    }
}