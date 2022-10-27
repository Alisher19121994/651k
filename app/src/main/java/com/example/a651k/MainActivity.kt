package com.example.a651k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 *
IntentService is an extension of the Service component class that
handles asynchronous requests (expressed as Intents) on demand.
Clients send requests through Context.startService(Intent) calls; the
service is started as needed, handles each Intent in turn using a worker thread,
and stops itself when it runs out of work.
 **/
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)
        val textView = findViewById<TextView>(R.id.text_id)

        start.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                textView.text = "Service is running!"
            }

        }
        stop.setOnClickListener {
            MyIntentService.stopService()
            textView.text = "Service stopped!"

        }

    }
}