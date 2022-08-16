package com.example.part17

import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.part17.databinding.ActivityAddBinding


class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when(item.itemId){
            R.id.menu_add_save->{
                val inputData=binding.addEditView.text.toString()
                val db=DBHelper(this).writableDatabase
                db.execSQL("insert into TODO_TB (todo) values (?)",
                arrayOf<String>(inputData)
                )

                db.close()
                val intent=intent
                intent.putExtra("result",inputData)
                setResult(Activity.RESULT_OK,intent)
                finish()
                true
            }
            else->true
        }
}