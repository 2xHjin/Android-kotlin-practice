package com.example.part10

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Build.VERSION.SDK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.part10.databinding.ActivityMainBinding
import com.example.part10.databinding.DialogLayoutBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    val alertButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("alert dialog ok click.....")
    }
    val items=arrayOf<String>("기본 알람 소리","Argon","Awaken","Bounce","Carbon")
    val c = Calendar.getInstance()


  //var alertDialog=AlertDialog.Builder(this)



    val customButtonClick={dialoginterface:DialogInterface,i:Int->
        showToast("custom dialog 확인 click.....")
    }
    fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var alertDialog=AlertDialog.Builder(this)

        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("잘 됬습니다","1")

        binding.btnAlert.setOnClickListener {
           // AlertDialog.Builder(this).run{
            alertDialog.run{
                setTitle("알림")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("OK",alertButtonClick)
                setNegativeButton("NO",null)
                Log.d("잘 됬습니다","2")

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
                setPositiveButton("확인",null)
                setNegativeButton("취소",null)
                show()
            }
        }


        binding.btnCustom.setOnClickListener {
            Log.d("잘 됬습니다","3")

            val dialogBinding=DialogLayoutBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run{
                Log.d("잘 됬습니다","4")

                setView(dialogBinding.root)
                setPositiveButton("확인",customButtonClick)
                setNegativeButton("취소",null)
                show()
            }
        }

        binding.btnDate.setOnClickListener {
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            Log.d("잘 됬습니다", "5")

       //     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
                        showToast("$year : ${month + 1} : $day")
                    }
                }, year, month, day).show()

            }

        //}

        binding.btnTime.setOnClickListener {
            val hour=c.get(Calendar.HOUR_OF_DAY)
            val minute=c.get(Calendar.MINUTE)

            TimePickerDialog(this,object:TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    showToast("$p1 : $minute")
                }
            },hour,minute,false).show()
        }
    }
}