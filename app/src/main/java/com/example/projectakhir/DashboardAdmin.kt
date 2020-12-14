package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard_admin.*

class DashboardAdmin : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_admin)

        findViewById<CardView>(R.id.buku).setOnClickListener(this)

        auth = FirebaseAuth.getInstance()

        logout.setOnClickListener{
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onSaveInstanceState(state: Bundle) {
        super.onSaveInstanceState(state)
        setContentView(R.layout.activity_dashboard_admin)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buku -> { startActivity(Intent(this, ListBook::class.java)) }

        }
    }
}