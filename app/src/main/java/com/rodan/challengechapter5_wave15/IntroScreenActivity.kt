package com.rodan.challengechapter5_wave15

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class IntroScreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screen)
        supportActionBar?.hide()

        val intent = Intent(this@IntroScreenActivity, MenuPageActivity::class.java)
        Handler().postDelayed({startActivity(intent)}, 2000)
    }
}