package com.example.part16

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.part16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //gallery request launcher..................
        val requestGalleryLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
        {
            try{
                val calRatio=calculateInSampleSize(
                    it.data!!.data!!,
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize)
                )
                val option=BitmapFactory.Options()
                option.inSampleSize=calRatio

                var inputStream=contentResolver.openInputStream(it.data!!.data!!)
                val bitmap=BitmapFactory.decodeStream(inputStream,null,option)
                inputStream!!.close()

                inputStream=null

                bitmap.let{
                    binding.userImageView.setImageBitmap(bitmap)
                }?:let{
                    Log.d("kkang","bitmap null")
                }
            }catch(e:Exception){
                e.printStackTrace()
            }
        }

        binding.galleryButton.setOnClickListener {
            //gallery app........................
            
        }

        //camera request launcher.................
        
        binding.cameraButton.setOnClickListener {
            //camera app......................
            //파일 준비...............
            
        }
    }

    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        try {
            var inputStream = contentResolver.openInputStream(fileUri)

            //inJustDecodeBounds 값을 true 로 설정한 상태에서 decodeXXX() 를 호출.
            //로딩 하고자 하는 이미지의 각종 정보가 options 에 설정 된다.
            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream!!.close()
            inputStream = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //비율 계산........................
        val (height: Int, width: Int) = options.run { outHeight to outWidth }
        var inSampleSize = 1
        //inSampleSize 비율 계산
        if (height > reqHeight || width > reqWidth) {

            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }

}