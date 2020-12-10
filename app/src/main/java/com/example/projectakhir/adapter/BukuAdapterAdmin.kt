package com.example.projectakhir.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.R
import com.example.projectakhir.model.Buku
import com.google.android.material.card.MaterialCardView

class BukuAdapterAdmin(
        val context: Context,
        var clickListner: OnCarItemClickListner
    ):
        RecyclerView.Adapter<BukuAdapterAdmin.BukuViewHolder>(){

    private val buku: MutableList<Buku> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        return BukuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_buku_admin, parent, false))
    }

    override fun onBindViewHolder(holder: BukuAdapterAdmin.BukuViewHolder, position: Int) {
        holder.binmodel(buku[position],clickListner)
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
        val txtLokasi: TextView = item.findViewById(R.id.tv_lokasi)

        fun binmodel (buku: Buku, action:OnCarItemClickListner){
            txtJudulBuku.text = "${buku.getJudulBuku()} - ${buku.getHarga()}"
            txtNamaPengarang.text = buku.getNamaPengerangBuku()
            txtDeskripsi.text = buku.getDeskripsiBuku()
            txtLokasi.text = buku.getAlamatToko()
            itemView.findViewById<MaterialCardView>(R.id.databukuadmin).setOnClickListener{
                action.onItemClick(buku,adapterPosition)
            }
        }

    }
}
interface OnCarItemClickListner{
    fun onItemClick(item: Buku, position: Int)
}