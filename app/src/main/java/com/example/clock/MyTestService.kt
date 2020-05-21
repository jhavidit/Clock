package com.example.clock

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyTestService(name: String) :IntentService("MyTestService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.i("MyTestService","Service running")

    }
}