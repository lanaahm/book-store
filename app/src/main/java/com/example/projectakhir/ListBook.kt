package com.example.projectakhir

import android.R
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_list_book.*

class ListBook : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_book)

        findViewById<ImageButton>(R.id.imageButton1).setOnClickListener(this)
        findViewById<TextView>(R.id.item1).setOnClickListener(this)
        findViewById<TextView>(R.id.item2).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var selectFr: Fragment = HomeFragment()
        when (v.id) {
            R.id.imageButton1 -> {
                startActivity(Intent(this, DashboardAdmin::class.java))
            }
            R.id.item1 -> {
                selectFr = ListBukuFragment()
                findViewById<TextView>(R.id.select)
                item1.setTextColor(Color.WHITE)
            }
            R.id.item2 -> {
                selectFr = ListTokoFragment()
            }
        }

        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.v_fragment_dadmin1, selectFr)
        fr.commit()
    }
}
