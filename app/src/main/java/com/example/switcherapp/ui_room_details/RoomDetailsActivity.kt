package com.example.switcherapp.ui_room_details

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.switcherapp.R
import com.example.switcherapp.ui.main.MainFragment

class RoomDetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_details)
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragment = RoomDetailsFragment(intent.getStringExtra("NAME")!!,intent.getBooleanExtra("LIGHTSTATE",false))
        fragmentManager.beginTransaction().replace(R.id.nav_room_details_fragment, fragment).commit()
    }
}