package com.example.switcherapp.ui_room_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.switcherapp.R
import com.example.switcherapp.RoomAdapter
import com.example.switcherapp.databinding.FragmentMainBinding
import com.example.switcherapp.databinding.FragmentRoomDetailBinding
import com.example.switcherapp.ui.main.MainViewModel

class RoomDetailsFragment(var roomName:String,var lightstate:Boolean) : Fragment() {
    private lateinit var binding : FragmentRoomDetailBinding
    private lateinit var viewModel: RoomDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this).get(RoomDetailsViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_room_detail, container, false)
        binding.roomTitleTextview.text=roomName
        binding.roomDescriptionTextview.text=("Your "+roomName+" light is")
        if (lightstate)
        {
            binding.lightImageview.setImageDrawable(resources.getDrawable(R.drawable.light_on))
            binding.lightStatusTextview.text = "ON"
        }
        else
        {
            binding.lightImageview.setImageDrawable(resources.getDrawable(R.drawable.light_off))
            binding.lightStatusTextview.text = "OFF"
        }
        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }
        return  binding.root
    }
}