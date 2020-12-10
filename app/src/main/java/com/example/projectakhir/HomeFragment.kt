package com.example.projectakhir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectakhir.adapter.BukuAdapter
import com.example.projectakhir.model.Buku
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var bukuAdapter: BukuAdapter
    val lm = LinearLayoutManager(activity)
    val addBukuList: MutableList<Buku> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        rc_buku.layoutManager = lm
        bukuAdapter = BukuAdapter(activity!!)
        rc_buku.adapter = bukuAdapter
//
//        addBukuList.add(Buku("Buku 1","Pengarang","Lorem ipsum dolar siamet", "Jl. Jalan","Rp. 20000"))
//        addBukuList.add(Buku("Buku 1","Pengarang","Lorem ipsum dolar siamet", "Jl. Jalan","Rp. 20000"))
//        addBukuList.add(Buku("Buku 1","Pengarang","Lorem ipsum dolar siamet", "Jl. Jalan","Rp. 20000"))
//        addBukuList.add(Buku("Buku 1","Pengarang","Lorem ipsum dolar siamet", "Jl. Jalan","Rp. 20000"))
//        addBukuList.add(Buku("Buku 1","Pengarang","Lorem ipsum dolar siamet", "Jl. Jalan","Rp. 20000"))

        bukuAdapter.setBuku(addBukuList)
    }
}