package com.example.projectakhir

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_dashboard_admin.*
import kotlinx.android.synthetic.main.activity_list_book.*
import kotlinx.android.synthetic.main.detail_buku.*
import java.util.zip.Inflater

class DetailBukuFrament : Fragment(){
    var id_buku: String? = ""
    var judul_buku: String? = ""
    var nama_pengerangBuku: String? = ""
    var lokasi: String? = ""
    var deskripsi_buku: String? = ""
    var harga: String? = ""
    private lateinit var tf_namaBuku: TextView
    private lateinit var tf_namaPengarang: TextView
    private lateinit var tf_lokasi: TextView
    private lateinit var tf_deskripsi: TextView
    private lateinit var tf_harga: TextView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootView =  inflater.inflate(R.layout.detail_buku, container, false)

        tf_namaBuku = rootView.findViewById(R.id.judulbuku)
        tf_namaPengarang = rootView.findViewById(R.id.pengarangbuku)
        tf_lokasi = rootView.findViewById(R.id.lokasi)
        tf_deskripsi = rootView.findViewById(R.id.deskripsi)
        tf_harga = rootView.findViewById(R.id.harga)

        id_buku = arguments?.getString("id_buku")
        judul_buku = arguments?.getString("judul_buku")
        nama_pengerangBuku = arguments?.getString("nama_pengerangBuku")
        lokasi = arguments?.getString("alamat_toko")
        deskripsi_buku = arguments?.getString("deskripsi_buku")
        harga = arguments?.getString("harga")

        tf_namaBuku.setText(judul_buku)
        tf_namaPengarang.setText(nama_pengerangBuku)
        tf_lokasi.setText(lokasi)
        tf_deskripsi.setText(deskripsi_buku)
        tf_harga.setText(harga)


        return rootView
    }

}