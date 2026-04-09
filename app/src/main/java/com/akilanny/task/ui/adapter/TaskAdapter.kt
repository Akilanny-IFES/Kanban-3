package com.akilanny.task.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akilanny.task.databinding.ItemTaskBinding

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.MyViewHolder> () {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        p0: MyViewHolder,
        p1: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class MyViewHolder(val binding : ItemTaskBinding): RecyclerView.ViewHolder(binding.root){

    }
}