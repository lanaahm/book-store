package com.example.projectakhir

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectakhir.databinding.FragmentMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.map.getMapAsync(this)
        binding.map.onCreate(savedInstanceState)
        binding.map.onResume()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val toko1 = LatLng(-7.952039, 112.622573)
        val toko2 = LatLng(-7.938587, 112.627078)
        mMap.addMarker(MarkerOptions().position(toko1).title("Toko Kelompok 9"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toko1))
        mMap.addMarker(MarkerOptions().position(toko2).title("Toko bersama"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toko2))
    }
}