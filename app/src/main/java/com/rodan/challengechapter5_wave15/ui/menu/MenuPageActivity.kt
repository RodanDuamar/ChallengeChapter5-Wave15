package com.rodan.challengechapter5_wave15.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodan.challengechapter5_wave15.R

class MenuPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_page)
        supportActionBar?.hide()
    }
}