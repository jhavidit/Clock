package com.example.clock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.core.content.ContextCompat.startActivity

class MyBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
       /* val int=Intent(context,MyTestService::class.java)
        context?.startService(int)*/



        val intent=Intent(context,AlarmScreen::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
       context?.startActivity(intent)

    }
}