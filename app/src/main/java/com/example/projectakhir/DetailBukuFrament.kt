package com.example.projectakhir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailBukuFrament : Fragment() {
    var id_buku: String? = ""
    var judul_buku: String? = ""
    var nama_pengerangBuku: String? = ""
    var alamat_toko: String? = ""
    var deskripsi_buku: String? = ""
    var harga: String? = ""
    private lateinit var tf_namaBuku: TextView
    private lateinit var tf_namaPengarang: TextView
    private lateinit var tf_tahunterbit: TextView
    private lateinit var tf_deskripsi: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootView =  inflater.inflate(R.layout.detail_buku, container, false)

        tf_namaBuku = rootView.findViewById(R.id.judulbuku)
        tf_namaPengarang = rootView.findViewById(R.id.pengarangbuku)
        tf_deskripsi = rootView.findViewById(R.id.deskripsi)

        id_buku = arguments?.getString("id_buku")
        judul_buku = arguments?.getString("judul_buku")
        nama_pengerangBuku = arguments?.getString("nama_pengerangBuku")
        alamat_toko = arguments?.getString("alamat_toko")
        deskripsi_buku = arguments?.getString("deskripsi_buku")
        harga = arguments?.getString("harga")

        tf_namaBuku.setText("$judul_buku - $harga")
        tf_namaPengarang.setText(nama_pengerangBuku)
        tf_deskripsi.setText(deskripsi_buku)

        return rootView
    }
}