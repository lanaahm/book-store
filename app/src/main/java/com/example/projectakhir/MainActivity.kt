package com.example.projectakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavListener)
        var fr = supportFragmentManager.beginTransaction()
        fr.add(R.id.v_fragment, HomeFragment())
        fr.commit()
    }

    private val onBottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { i ->
        var selectFr: Fragment = HomeFragment()

        when(i.itemId){
            R.id.home -> {
                selectFr = HomeFragment()
            }
            R.id.location -> {
                selectFr = LocationFragment()
            }
            R.id.user -> {
                selectFr = UserFragment()
            }
        }

        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.v_fragment, selectFr)
        fr.commit()
        true
    }
}