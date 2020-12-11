package com.example.projectakhir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectakhir.adapter.BukuAdapter
import com.example.projectakhir.adapter.BukuAdapterAdmin
import com.example.projectakhir.adapter.OnBukuItemClickListner
import com.example.projectakhir.model.Buku
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_list_buku.*

class HomeFragment : Fragment(), OnBukuItemClickListner {
    lateinit var bukuAdapter: BukuAdapter
    val lm = LinearLayoutManager(activity)
    val addBukuList: MutableList<Buku> = ArrayList()

    private val database= FirebaseDatabase.getInstance().getReference("dataBuku")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        rc_buku.layoutManager = lm
        bukuAdapter = BukuAdapter(context!!,this)
        rc_buku.adapter = bukuAdapter
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (h in snapshot.children) {
                    addBukuList.add(h.getValue(Buku::class.java)!!)
                }
                bukuAdapter.setBuku(addBukuList)
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    override fun onItemClick(item: Buku, position: Int) {
        val bundle = Bundle()
        bundle.putString("id_buku",item.id)
        bundle.putString("judul_buku",item.getJudulBuku())
        bundle.putString("judul_buku",item.getJudulBuku())
        bundle.putString("nama_pengerangBuku",item.getNamaPengerangBuku())
        bundle.putString("alamat_toko",item.getAlamatToko())
        bundle.putString("deskripsi_buku",item.getDeskripsiBuku())
        bundle.putString("harga",item.getHarga())

        val transaction = fragmentManager?.beginTransaction()
        val frag2 = DetailBukuFrament()
        frag2.arguments = bundle

        transaction?.replace(R.id.v_fragment, frag2)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction?.commit()
    }
}