package com.rodan.challengechapter5_wave15.ui.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.rodan.challengechapter5_wave15.ui.menu.MenuPageActivity
import com.rodan.challengechapter5_wave15.R
import com.rodan.challengechapter5_wave15.ui.landing.LandingPageActivity

class IntroScreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screen)
        supportActionBar?.hide()
        setTimerSplashScreen()
    }

    fun setTimerSplashScreen(){
        val intent = Intent(this@IntroScreenActivity, LandingPageActivity::class.java)
        Handler().postDelayed({
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()}, 1500)
    }
}