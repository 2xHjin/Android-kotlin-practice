package com.example.kandroidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Lab6_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab6_2)

        val target_button:Button=findViewById(R.id.button5)

        val visible_true=findViewById<Button>(R.id.button10)
        val visible_false=findViewById<Button>(R.id.button11)

        visible_true.setOnClickListener{
            target_button.visibility= View.VISIBLE;
        }
        visible_false.setOnClickListener{
            target_button.visibility= View.INVISIBLE;
        }
    }
}