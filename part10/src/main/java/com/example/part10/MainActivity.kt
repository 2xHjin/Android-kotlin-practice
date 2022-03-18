package com.example.part10

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.part10.databinding.ActivityMainBinding
import com.example.part10.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {
    val alertButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("alert dialog ok click.....")
    }

    val items=arrayOf<String>("기본 알람 소리","Argon","Awaken","Bounce","Carbon")

    val listButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("${items[i]} 선택하셨습니다.")
    }

    val customButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("custom dialog 확인 click.....")
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
                setPositiveButton("OK",alertButtonClick)
                setNegativeButton("NO",null)
                show()
            }
        }

        binding.btnList.setOnClickListener {
            AlertDialog.Builder(this).run{
                setTitle("알람 벨소리")
                setSingleChoiceItems(items,1,object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        showToast("${items[p1]} 선택하셨습니다.")
                    }
                })
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("확인",null)
                setNegativeButton("취소",null)
                show()
            }
        }

        binding.btnCustom.setOnClickListener {
            val dialogBinding=DialogLayoutBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run{
                setView(dialogBinding.root)
                setPositiveButton("확인",customButtonClick)
                setNegativeButton("취소",null)
                show()
            }
        }
    }
}