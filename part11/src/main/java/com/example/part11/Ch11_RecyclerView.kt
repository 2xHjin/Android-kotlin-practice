package com.example.part11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.part11.databinding.ActivityCh11RecyclerViewBinding
import com.example.part11.databinding.ItemMainBinding

class Ch11_RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityCh11RecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas= mutableListOf<String>()
        for(i in 1..10){
            datas.add("Item $i")
        }
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=MyAdapter(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
    }

    class MyViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

    class MyAdapter(val datas:MutableList<String>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun getItemCount(): Int =datas.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                RecyclerView.ViewHolder =MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Log.d("kang","onBindViewHolder : $position")
            val binding=(holder as MyViewHolder).binding
            binding.itemData.text=datas[position]
            binding.itemRoot.setOnClickListener{
                Log.d("kang","item root click : $position")
            }
        }
    }
}

