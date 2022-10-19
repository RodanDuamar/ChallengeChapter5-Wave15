package com.rodan.challengechapter5_wave15.ui.intro

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.rodan.challengechapter5_wave15.databinding.ActivityIntroScreenBinding
import com.rodan.challengechapter5_wave15.ui.landing.LandingPageActivity

class IntroScreenActivity: AppCompatActivity() {
    private val binding : ActivityIntroScreenBinding by lazy {
        ActivityIntroScreenBinding.inflate(layoutInflater)
    }

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setTimerSplashScreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        //destroy the timer for case new activity still opened when splashscreen destroyed
        if (timer != null){
            timer?.cancel()
            timer = null
        }
    }

    private fun setTimerSplashScreen(){
        timer = object : CountDownTimer(2000, 1000){
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val intent = Intent(this@IntroScreenActivity, LandingPageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        timer?.start()
    }
}