package com.example.kandroidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kandroidlab.databinding.ActivityLab64Binding
import com.example.kandroidlab.databinding.ActivityMainBinding

class Lab6_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityLab64Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visibleBtn.setOnClickListener{
            binding.targetView.visibility= View.VISIBLE
        }

        binding.invisibleBtn.setOnClickListener {
            binding.targetView.visibility=View.INVISIBLE
        }
    }
}