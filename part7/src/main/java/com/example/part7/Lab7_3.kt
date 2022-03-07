package com.example.part7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.part7.databinding.ActivityLab73Binding

class Lab7_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityLab73Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.button.visibility= View.INVISIBLE
            binding.imageView.visibility=View.VISIBLE
        }

        binding.imageView.setOnClickListener {
            binding.button.visibility=View.VISIBLE
            binding.imageView.visibility=View.INVISIBLE
        }

    }
}