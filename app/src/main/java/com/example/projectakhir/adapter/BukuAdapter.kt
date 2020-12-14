package com.example.projectakhir.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectakhir.R
import com.example.projectakhir.model.Buku
import com.google.android.material.card.MaterialCardView

class BukuAdapter(
    val context: Context,
    var clickListner: OnBukuItemClickListner): RecyclerView.Adapter<BukuAdapter.BukuViewHolder>(){

    private val buku: MutableList<Buku> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BukuViewHolder {
        return BukuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_buku, parent, false))
    }

    override fun onBindViewHolder(holder: BukuAdapter.BukuViewHolder, position: Int) {
        holder.binmodel(buku[position], clickListner)
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

        val txtJudulBuku: TextView = item.findViewById(R.id.tv_judul_home)
        val txtDeskripsi: TextView = item.findViewById(R.id.deskrpsibukuhome)
        val txtLokasi: TextView = item.findViewById(R.id.lokasi)
        val txtHarga: TextView = item.findViewById(R.id.harga)
//        val txtPengarang: TextView = item.findViewById(R.id.pengarangbuku)

        @SuppressLint("SetTextI18n")
        fun binmodel (buku: Buku, action:OnBukuItemClickListner){
            txtJudulBuku.text = buku.getJudulBuku()
            txtDeskripsi.text = buku.getDeskripsiBuku()
            txtHarga.text = buku.getHarga()
            txtLokasi.text = buku.getAlamatToko()
//            txtPengarang.text = buku.getNamaPengerangBuku()
            itemView.findViewById<MaterialCardView>(R.id.databuk).setOnClickListener{
                action.onItemClick(buku,adapterPosition)
            }
        }
    }
}
interface OnBukuItemClickListner{
    fun onItemClick(item: Buku, position: Int)
}