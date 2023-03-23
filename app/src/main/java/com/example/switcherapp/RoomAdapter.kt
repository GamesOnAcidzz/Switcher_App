package com.example.switcherapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.switcherapp.ui_room_details.RoomDetailsActivity
import com.example.switcherapp.ui_room_details.RoomDetailsFragment

class RoomAdapter (private var list : List<Room>,val ctx:Context): RecyclerView.Adapter<RoomAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomNameTextview = itemView.findViewById<TextView>(R.id.room_name_textview)
        val lightSwitch = itemView.findViewById<Switch>(R.id.light_switch)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.room_item, parent,false)
        return ViewHolder(inflater)
    }
    fun updateData(list: List<Room>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.roomNameTextview.text= list[position].name
        holder.roomNameTextview.setOnClickListener {
            val intent = Intent(this.ctx,RoomDetailsActivity::class.java)
            intent.putExtra("NAME",list[position].name)
            intent.putExtra("LIGHTSTATE",list[position].lightState)
            startActivity(this.ctx,intent,null)
        }
        holder.lightSwitch.setOnClickListener {
            list[position].lightState = holder.lightSwitch.isChecked
        }

    }

}
