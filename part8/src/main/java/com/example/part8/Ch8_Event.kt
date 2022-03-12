package com.example.part8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.part8.databinding.ActivityCh8EventBinding

class Ch8_Event : AppCompatActivity() {
    var initTime=0L
    var pauseTime=0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityCh8EventBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}