package com.example.switcherapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.switcherapp.R
import com.example.switcherapp.Room
import com.example.switcherapp.RoomAdapter
import com.example.switcherapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding :FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    var roomList:List<Room> = listOf(Room("Kitchen"),
        Room("Living Room"),
        Room("Master Bedroom"),
        Room("Guest's Bedroom")
    )
    companion object {
        fun newInstance() = MainFragment()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val adapter=RoomAdapter(roomList,requireContext())
        adapter.updateData(roomList)

        val layoutManager  = LinearLayoutManager(requireContext())
        binding.roomRecyclerView.layoutManager = layoutManager
        binding.roomRecyclerView.adapter=adapter
        adapter.notifyDataSetChanged()

        return  binding.root
    }

}