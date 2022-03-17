package com.example.part10

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.part10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding= ActivityMainBinding.inflate(layoutInflater)
    val alertButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("alert dialog ok click.....")
    }

    val items=arrayOf<String>("기본 알람 소리","Argon","Awaken","Bounce","Carbon")

    val eventHandler= object : DialogInterface.OnClickListener{
        override fun onClick(p0: DialogInterface?, p1: Int) {
            if(p0==binding.btnCustom&&p1==DialogInterface.BUTTON_POSITIVE){
                showToast("custom dialog 확인 click")
            }
            else if(p0==binding.btnList){
                showToast("${items[p1]}을 선택하셨습니다")
            }
            else if(p0==binding.btnAlert&&p1==DialogInterface.BUTTON_POSITIVE){
                showToast("custom dialog ok click")
            }
        }
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

        setContentView(binding.root)

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("알림")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("OK",eventHandler)
                setNegativeButton("NO",null)
                show()
            }
        }
    }
}