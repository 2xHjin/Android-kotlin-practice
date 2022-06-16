package com.example.part13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.part13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var datas:MutableList<String>?=null
    lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}