package com.example.projectakhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.registrasi.*

class Regis : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.registrasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        log.setOnClickListener {
            var fr = getFragmentManager()?.beginTransaction()
            fr?.replace(R.id.v_fragment, UserFragment())
            fr?.commit()
        }

    }
}