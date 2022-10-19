package com.rodan.challengechapter5_wave15.playgame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.rodan.challengechapter5_wave15.R
import com.rodan.challengechapter5_wave15.databinding.ActivityPlayBinding
import com.rodan.challengechapter5_wave15.ui.dialog.MenuDialog
import com.rodan.challengechapter5_wave15.ui.dialog.OnMenuSelectedListener
import com.rodan.challengechapter5_wave15.ui.landing.LandingPageActivity
import com.rodan.challengechapter5_wave15.utils.PlayerMenu
import com.rodan.challengechapter5_wave15.utils.Result.DRAW
import com.rodan.challengechapter5_wave15.utils.Result.PLAYER_ONE_WIN
import com.rodan.challengechapter5_wave15.utils.Result.PLAYER_TWO_WIN


class PlayActivity : AppCompatActivity(), GameManager {
    private val binding: ActivityPlayBinding by lazy {
        ActivityPlayBinding.inflate(layoutInflater)
    }

    private val sendName: String? by lazy {
        intent.getStringExtra(EXTRA_TEXT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        setOnClickListener()
    }

    companion object{
        private const val EXTRA_TEXT = "EXTRA_TEXT"
        private const val EXTRA_MULTIPLAYER_MODE = "EXTRA_MULTIPLAYER_MODE"

        fun startActivity(context: Context, isUsingMultiplayerMode: Boolean, name: String){
            context.startActivity(Intent(context, PlayActivity::class.java).apply {
                putExtra(EXTRA_MULTIPLAYER_MODE, isUsingMultiplayerMode)
                putExtra(EXTRA_TEXT, name)
            })
        }
    }

    private fun setOnClickListenerMultiplayer(){
        binding.tvPlayer.text = getString(R.string.player_name, sendName)
        binding.tvOpponent.text = getString(R.string.player_2)

        binding.ivRockLeftPlayer.setOnClickListener{
            MultiplayerMode()
        }
        binding.ivPaperLeftPlayer.setOnClickListener{
            MultiplayerMode()
        }
        binding.ivScissorLeftPlayer.setOnClickListener{
            MultiplayerMode()
        }

        binding.ivRockRightPlayer.setOnClickListener{
            MultiplayerMode()
        }
        binding.ivPaperRightPlayer.setOnClickListener{
            MultiplayerMode()
        }
        binding.ivScissorRightPlayer.setOnClickListener{
            MultiplayerMode()
        }
    }

    private fun setOnClickListener() {
        binding.tvPlayer.text = getString(R.string.player_name, sendName)
        binding.tvOpponent.text = getString(R.string.cpu)

        binding.ivRockLeftPlayer.setOnClickListener{
            rockSinglePlayer()
        }
        binding.ivPaperLeftPlayer.setOnClickListener{
            paperSinglePlayer()
        }
        binding.ivScissorLeftPlayer.setOnClickListener{
            scissorSinglePlayer()
        }
        binding.ivRestart.setOnClickListener{
            reset()
        }
        binding.flClose.setOnClickListener {
            val intent = Intent(this@PlayActivity, LandingPageActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        binding.tvStatusGame.text = getString(R.string.versus)
    }

    val ivRockPlayerTwo: ImageView by lazy {
        binding.ivRockRightPlayer
    }
    val ivPaperPlayerTwo: ImageView by lazy {
        binding.ivPaperRightPlayer
    }
    val ivScissorPlayerTwo: ImageView by lazy {
        binding.ivScissorRightPlayer
    }

    val ivRockPlayerOne: ImageView by lazy {
        binding.ivRockLeftPlayer
    }
    val ivPaperPlayerOne: ImageView by lazy {
        binding.ivPaperLeftPlayer
    }
    val ivScissorplayerOne: ImageView by lazy {
        binding.ivScissorLeftPlayer
    }

    fun reset(){
        binding.tvStatusGame.text = getString(R.string.versus)

        ivRockPlayerTwo.visibility = View.VISIBLE
        ivPaperPlayerTwo.visibility = View.VISIBLE
        ivScissorPlayerTwo.visibility = View.VISIBLE

        ivRockPlayerOne.visibility = View.VISIBLE
        ivPaperPlayerOne.visibility = View.VISIBLE
        ivScissorplayerOne.visibility = View.VISIBLE
    }

    lateinit var player1Choice: String

    override fun rockSinglePlayer() {

        player1Choice = PlayerMenu.ROCK

        MenuDialog().apply {
            setOnMenuSelectedListener(object : OnMenuSelectedListener{
                override fun onPlayAgainClicked(dialog: DialogFragment) {
                    dialog.dismiss()
                    reset()
                    Toast.makeText(this@PlayActivity, "Mulai", Toast.LENGTH_SHORT).show()
                }

                override fun onBackToMenuClicked(dialog: DialogFragment) {
                    dialog.dismiss()
                    onBackPressed()
                }
            })
            arguments?.putString(MenuDialog.EXTRA_RESULT,sendName)

        }.show(supportFragmentManager, null)
    }

    override fun paperSinglePlayer() {
        player1Choice = PlayerMenu.PAPER

        MenuDialog().apply {
            setOnMenuSelectedListener(object : OnMenuSelectedListener{
                override fun onPlayAgainClicked(dialog: DialogFragment) {
                    dialog.dismiss()
                    reset()
                    Toast.makeText(this@PlayActivity, "Mulai", Toast.LENGTH_SHORT).show()
                }
                override fun onBackToMenuClicked(dialog: DialogFragment) {
                    dialog.dismiss()
                    onBackPressed()
                }
            })
        }.show(supportFragmentManager, null)

    }

    override fun scissorSinglePlayer() {
        player1Choice = PlayerMenu.SCISSOR

        MenuDialog().apply {
            setOnMenuSelectedListener(object : OnMenuSelectedListener{
                override fun onPlayAgainClicked(dialog: DialogFragment) {
                    dialog.dismiss()
                    reset()
                    Toast.makeText(this@PlayActivity, "Mulai", Toast.LENGTH_SHORT).show()
                }
                override fun onBackToMenuClicked(dialog: DialogFragment) {
                    dialog.dismiss()
                    onBackPressed()
                }
            })
        }.show(supportFragmentManager, null)
    }

    private val isUsingMultiplayerMode : Boolean by lazy {
        intent.getBooleanExtra(EXTRA_MULTIPLAYER_MODE,false)
    }

}

class MultiplayerMode(): GameManager {
    lateinit var player1Choice: String

    lateinit var ivRockPlayerTwo: ImageView
    lateinit var ivPaperPlayerTwo: ImageView
    lateinit var ivScissorPlayerTwo: ImageView

    lateinit var ivRockPlayerOne: ImageView
    lateinit var ivPaperPlayerOne: ImageView
    lateinit var ivScissorplayerOne: ImageView

    fun reset(){

        ivRockPlayerTwo.visibility = View.VISIBLE
        ivPaperPlayerTwo.visibility = View.VISIBLE
        ivScissorPlayerTwo.visibility = View.VISIBLE

        ivRockPlayerOne.visibility = View.VISIBLE
        ivPaperPlayerOne.visibility = View.VISIBLE
        ivScissorplayerOne.visibility = View.VISIBLE
    }

    private lateinit var result: String

    override fun rockSinglePlayer() {

        val player2Choice = 0
        when (player2Choice){
            0 -> ivRockPlayerTwo.visibility = View.VISIBLE
            1 -> ivPaperPlayerTwo.visibility = View.INVISIBLE
            2 -> ivScissorPlayerTwo.visibility = View.INVISIBLE
        }
        when (player2Choice){
            0 -> result = DRAW
            1 -> result = PLAYER_TWO_WIN
            2 -> result = PLAYER_ONE_WIN
        }
        player1Choice = PlayerMenu.ROCK
        when(player1Choice){
            PlayerMenu.ROCK -> ivRockPlayerOne.visibility = View.INVISIBLE
            PlayerMenu.PAPER -> ivPaperPlayerOne.visibility = View.INVISIBLE
            PlayerMenu.SCISSOR -> ivScissorplayerOne.visibility = View.INVISIBLE
        }
    }

    override fun paperSinglePlayer() {
        val player2Choice = 1
        when (player2Choice){
            0 -> ivRockPlayerTwo.visibility = View.INVISIBLE
            1 -> ivPaperPlayerTwo.visibility = View.VISIBLE
            2 -> ivScissorPlayerTwo.visibility = View.INVISIBLE
        }
        when (player2Choice){
            0 -> result = PLAYER_TWO_WIN
            1 -> result = DRAW
            2 -> result = PLAYER_ONE_WIN
        }
        player1Choice = PlayerMenu.ROCK
        when(player1Choice){
            PlayerMenu.ROCK -> ivRockPlayerOne.visibility = View.INVISIBLE
            PlayerMenu.PAPER -> ivPaperPlayerOne.visibility = View.INVISIBLE
            PlayerMenu.SCISSOR -> ivScissorplayerOne.visibility = View.INVISIBLE
        }
    }

    override fun scissorSinglePlayer() {
        val player2Choice = 2
        when (player2Choice){
            0 -> ivRockPlayerTwo.visibility = View.VISIBLE
            1 -> ivPaperPlayerTwo.visibility = View.INVISIBLE
            2 -> ivScissorPlayerTwo.visibility = View.INVISIBLE
        }
        when (player2Choice){
            0 -> result = DRAW
            1 -> result = PLAYER_TWO_WIN
            2 -> result = PLAYER_ONE_WIN
        }
        player1Choice = PlayerMenu.ROCK
        when(player1Choice){
            PlayerMenu.ROCK -> ivRockPlayerOne.visibility = View.INVISIBLE
            PlayerMenu.PAPER -> ivPaperPlayerOne.visibility = View.INVISIBLE
            PlayerMenu.SCISSOR -> ivScissorplayerOne.visibility = View.INVISIBLE
        }
    }
}

interface GameManager{
    fun rockSinglePlayer()
    fun paperSinglePlayer()
    fun scissorSinglePlayer()
}