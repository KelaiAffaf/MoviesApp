    package com.example.tp7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }, SPLASH_TIME_OUT)
    }
}
