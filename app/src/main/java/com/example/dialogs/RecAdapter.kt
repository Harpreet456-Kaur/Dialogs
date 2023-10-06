package com.example.dialogs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dialogs.databinding.ItemsBinding

class RecAdapter(val list: ArrayList<RecModel>):RecyclerView.Adapter<RecAdapter.viewHolder>(){
    class viewHolder(val binding: ItemsBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.item.text = list[position].name
    }
}