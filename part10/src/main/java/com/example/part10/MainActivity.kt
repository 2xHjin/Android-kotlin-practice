package com.example.part10

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.part10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val alertButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("alert dialog ok click.....")
    }

    val listButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("alert dialog ok click.....")
    }

    val customButtonClick={dialoginterface:DialogInterface,i:Int->
        
        showToast("alert dialog ok click.....")
    }
    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("알림")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("OK",null)
                setNegativeButton("NO",null)
                show()
            }
        }
    }
}