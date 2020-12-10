package com.example.projectakhir

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projectakhir.model.Buku
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.FirebaseDatabase

class EditBukuFragment : Fragment() {
    var id_buku: String? = ""
    var judul_buku: String? = ""
    var nama_pengerangBuku: String? = ""
    var alamat_toko: String? = ""
    var deskripsi_buku: String? = ""
    var harga: String? = ""

    private lateinit var tf_namaBuku: TextInputLayout
    private lateinit var tf_namaPengarang: TextInputLayout
    private lateinit var tf_tahunterbit: TextInputLayout
    private lateinit var tf_deskripsi: TextInputLayout

    private val database= FirebaseDatabase.getInstance().getReference("dataBuku")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =  inflater.inflate(R.layout.fragment_edit_buku, container, false)

        tf_namaBuku = rootView.findViewById(R.id.nama_buku)
        tf_namaPengarang = rootView.findViewById(R.id.pengarang)
        tf_tahunterbit = rootView.findViewById(R.id.thnterberit)
        tf_deskripsi = rootView.findViewById(R.id.keterangan)

        id_buku = arguments?.getString("id_buku")
        judul_buku = arguments?.getString("judul_buku")
        nama_pengerangBuku = arguments?.getString("nama_pengerangBuku")
        alamat_toko = arguments?.getString("alamat_toko")
        deskripsi_buku = arguments?.getString("deskripsi_buku")
        harga = arguments?.getString("harga")

        tf_namaBuku.editText?.setText(judul_buku)
        tf_namaPengarang.editText?.setText(nama_pengerangBuku)
        tf_tahunterbit.editText?.setText(alamat_toko)
        tf_deskripsi.editText?.setText(deskripsi_buku)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<MaterialButton>(R.id.simpan_buku2).setOnClickListener {
            database.child(id_buku.toString()).removeValue()

            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.v_fragment_dadmin1, ListBukuFragment())
            fr?.commit()
        }
        view.findViewById<MaterialButton>(R.id.simpan_buku).setOnClickListener {

            val namaBuku = tf_namaBuku.editText?.text.toString()
            val namaPengarang = tf_namaPengarang.editText?.text.toString()
            val tahunterbit = tf_tahunterbit.editText?.text.toString()
            val deskripsi = tf_deskripsi.editText?.text.toString()
            when {
                TextUtils.isEmpty(namaBuku) -> cekTf(tf_namaBuku, ".")
                TextUtils.isEmpty(namaPengarang) -> cekTf(tf_namaPengarang, ".")
                TextUtils.isEmpty(tahunterbit) -> cekTf(tf_tahunterbit, ".")
                TextUtils.isEmpty(deskripsi) -> cekTf(tf_deskripsi, ".")
                else -> {
//                    database.child(Buku.id!!).setValue(
//                            Buku(
//                                    namaBuku,
//                                    namaPengarang,
//                                    tahunterbit,
//                                    deskripsi,
//                                    "20000"
//                            )
                    database.child(id_buku.toString()).setValue(
                        Buku(
                            id_buku,
                            namaBuku,
                            namaPengarang,
                            tahunterbit,
                            deskripsi,
                            "20000"
                        )
                    ).addOnSuccessListener(OnSuccessListener {
                        cleanTf()

                        var fr = fragmentManager?.beginTransaction()
                        fr?.replace(R.id.v_fragment_dadmin1, ListBukuFragment())
                        fr?.commit()

                        activity!!.findViewById<TextView>(R.id.select)?.animate()!!.x(Float.MIN_VALUE).duration = 100;
                        activity!!.findViewById<TextView>(R.id.item2).setTextColor(activity!!.findViewById<TextView>(R.id.item1).textColors)
                        activity!!.findViewById<TextView>(R.id.select).setTextColor(Color.WHITE)

                        Toast.makeText(activity, "Data berhasil disimpan", Toast.LENGTH_LONG).show();
                    }).addOnFailureListener {
                        Toast.makeText(activity, "Data gagal disimpan", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }

    private fun cekTf(tf: TextInputLayout, msg: String){
        tf.editText?.error = "${msg} tidak boleh kosong"
        tf.requestFocus()
    }
    private fun cleanTf(){
        tf_namaBuku.editText!!.text = null
        tf_namaPengarang.editText!!.text = null
        tf_tahunterbit.editText!!.text = null
        tf_deskripsi.editText!!.text = null
    }

}

