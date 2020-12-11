package com.example.projectakhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectakhir.adapter.BukuAdapterAdmin
import com.example.projectakhir.adapter.OnclickBukuAdmin
import com.example.projectakhir.model.Buku
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_list_buku.*


class ListBukuFragment : Fragment(), OnclickBukuAdmin {
    lateinit var bukuAdapter: BukuAdapterAdmin
    lateinit var comm: Communicator

    val lm = LinearLayoutManager(activity)
    val addBukuList: MutableList<Buku> = mutableListOf()

    private val database= FirebaseDatabase.getInstance().getReference("dataBuku")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list_buku, container, false)

        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        rc_buku_admin.layoutManager = lm
        bukuAdapter = BukuAdapterAdmin(context!!,this)
        rc_buku_admin.adapter = bukuAdapter
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
        val frag2 = EditBukuFragment()
        frag2.arguments = bundle

        transaction?.replace(R.id.v_fragment_dadmin1, frag2)
        transaction?.addToBackStack(null)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction?.commit()
    }

}