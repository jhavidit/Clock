package com.example.clock

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    //@RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_alarm_set.setOnClickListener {
            var alarmTime = time_alarm.text.toString().toInt()
            var intent = Intent(applicationContext, MyBroadcastReceiver::class.java)
            pendingIntent = PendingIntent.getBroadcast(applicationContext, 1, intent, 0)
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            if (Build.VERSION.SDK_INT < 23) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + alarmTime * 1000,
                        pendingIntent
                    )
                } else {
                    alarmManager.set(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + alarmTime * 1000,
                        pendingIntent
                    )
                }
            } else {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + alarmTime * 1000,
                    pendingIntent
                )
            }



            Toast.makeText(
                applicationContext,
                "Alarm is set for $alarmTime seconds later",
                Toast.LENGTH_LONG
            ).show()
        }
    }


}
