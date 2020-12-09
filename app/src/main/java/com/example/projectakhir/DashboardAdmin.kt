package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_dashboard_admin.*

class DashboardAdmin : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_admin)

        findViewById<CardView>(R.id.buku).setOnClickListener(this)
        findViewById<CardView>(R.id.toko).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buku -> { startActivity(Intent(this, ListBook::class.java)) }
            R.id.toko -> { startActivity(Intent(this, ListToko::class.java)) }
        }
    }
}