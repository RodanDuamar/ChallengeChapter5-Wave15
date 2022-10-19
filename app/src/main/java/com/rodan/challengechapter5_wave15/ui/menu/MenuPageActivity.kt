package com.rodan.challengechapter5_wave15.ui.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.rodan.challengechapter5_wave15.R
import com.rodan.challengechapter5_wave15.databinding.ActivityMenuPageBinding
import com.rodan.challengechapter5_wave15.playgame.PlayActivity
import com.rodan.challengechapter5_wave15.utils.PlayerMenu

class MenuPageActivity : AppCompatActivity() {
    val binding: ActivityMenuPageBinding by lazy {
        ActivityMenuPageBinding.inflate(layoutInflater)
    }

    private val nameReceiver: String? by lazy {
        intent.getStringExtra(EXTRA_TEXT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        setName()
        setOnClickListener()
    }

    private fun setOnClickListener(){
        binding.llMenuPlayer.setOnClickListener{
            //Todo: Access game vs player
            PlayActivity.startActivity(this,false,"$nameReceiver")

        }
        binding.llMenuComputer.setOnClickListener {
            //Todo: Access game vs computer
            PlayActivity.startActivity(this, true, "$nameReceiver")

        }
    }

    fun setName(){
        binding.tvPlayerVsPlayer.text = getString(R.string.input_player_vs_player, nameReceiver)
        binding.tvPlayerVsComputer.text = getString(R.string.input_player_vs_computer, nameReceiver)

        Snackbar.make(binding.root, "Selamat Datang $nameReceiver", Snackbar.LENGTH_SHORT).show()
    }

    companion object{
        const val EXTRA_TEXT = "EXTRA_TEXT"

        fun startActivity(context: Context, nameParam: String){
            context.startActivity(Intent(context, MenuPageActivity::class.java).apply {
                putExtra(EXTRA_TEXT,nameParam)
            })

        }
    }



}