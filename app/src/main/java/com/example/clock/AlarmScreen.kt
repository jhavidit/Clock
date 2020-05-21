package com.example.clock

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alarm_screen.*

class AlarmScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_screen)

        var alarmSound= MediaPlayer.create(applicationContext,R.raw.default_alarm_tone)
        alarmSound.start()
        alarmSound.isLooping=true
        btn_alarm_stop.setOnClickListener {
            alarmSound.stop()
            finish()
        }
    }
}
