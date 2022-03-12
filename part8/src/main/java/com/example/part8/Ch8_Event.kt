package com.example.part8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import com.example.part8.databinding.ActivityCh8EventBinding


class Ch8_Event : AppCompatActivity() {
    var initTime=0L
    var pauseTime=0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityCh8EventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            /*부팅된 시점부터 현재까지의 시간을 millisecond로 리턴합니다.
            즉, 부팅 직후에는 0을 리턴하고 10초가 지났다면 10000이 리턴됩니다.

중요한 것은 디바이스가 Sleep 상태에 있어도 시간은 측정이 됩니다.
만약 부팅된지 10초가 지났고, 이 중에 5초가 Sleep 상태였어도 API는 10초를 리턴합니다.

따라서, 시간 간격(Interval)을 측정할 때는 이 API를 사용하면 좋습니다.*/
            binding.chronometer.base= SystemClock.elapsedRealtime()+pauseTime
            binding.chronometer.start()

            binding.stopButton.isEnabled=true
            binding.resetButton.isEnabled=true
            binding.startButton.isEnabled=false
        }

        binding.stopButton.setOnClickListener {
            pauseTime=binding.chronometer.base-SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.stopButton.isEnabled=false
            binding.resetButton.isEnabled=true
            binding.startButton.isEnabled=true
        }

        binding.resetButton.setOnClickListener {
            pauseTime=0L
            binding.chronometer.base=SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.stopButton.isEnabled=false
            binding.resetButton.isEnabled=false
            binding.startButton.isEnabled=true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis()-initTime>3000){
                Toast.makeText(this,"종료하려면 한 번 더 누르세요!!",Toast.LENGTH_SHORT).show()
                initTime=System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}