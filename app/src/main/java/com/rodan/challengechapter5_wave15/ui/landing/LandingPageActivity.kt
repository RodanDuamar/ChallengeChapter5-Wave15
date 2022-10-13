package com.rodan.challengechapter5_wave15.ui.landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment
import com.rodan.challengechapter5_wave15.R
import com.rodan.challengechapter5_wave15.ui.landing.entername.EnterNameFragment

class LandingPageActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setupSlider()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        if (currentFragment is OnFinishNavigate){
            currentFragment.onFinishNavigate()
        }
    }

    private fun setupSlider(){
        isSkipButtonEnabled = false
        addSlide(AppIntroFragment.createInstance(
            description = getString(R.string.text_player_vs_player),
            imageDrawable = R.drawable.ic_landing_page1,
            descriptionColorRes = R.color.black,
            backgroundColorRes = R.color.white,
            titleTypefaceFontRes = R.font.comic_sans_ms,
            descriptionTypefaceFontRes = R.font.comic_sans_ms
        ))
        addSlide(AppIntroFragment.createInstance(
            description = getString(R.string.text_player_vs_computer),
            imageDrawable = R.drawable.ic_landing_page2,
            descriptionColorRes = R.color.black,
            backgroundColorRes = R.color.white,
            titleTypefaceFontRes = R.font.comic_sans_ms,
            descriptionTypefaceFontRes = R.font.comic_sans_ms
        ))
        addSlide(EnterNameFragment())
    }
}

interface OnFinishNavigate{
    fun onFinishNavigate()
}