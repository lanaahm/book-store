package com.example.projectakhir

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectakhir.adapter.BukuAdapterAdmin
import com.example.projectakhir.model.Buku
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_list_buku.*


class ListBukuFragment : Fragment() {
    lateinit var bukuAdapter: BukuAdapterAdmin
    val lm = LinearLayoutManager(activity)
    val addBukuList: MutableList<Buku> = mutableListOf()

    private val database= FirebaseDatabase.getInstance().getReference("dataBuku")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_buku, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        rc_buku_admin.layoutManager = lm
        bukuAdapter = BukuAdapterAdmin(context!!)
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
}