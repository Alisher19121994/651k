package com.example.a651k

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("service") {


    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService() {
            Log.d("MyIntentService", "Service is stopped!")
            isRunning = false
            instance.stopSelf()
        }
    }

    init {
        instance = this
    }


    override fun onHandleIntent(intent: Intent?) {

        try {

            isRunning = true

            while (isRunning) {

                Log.d("MyIntentService", "Service is running!")
                Thread.sleep(1000)

            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}