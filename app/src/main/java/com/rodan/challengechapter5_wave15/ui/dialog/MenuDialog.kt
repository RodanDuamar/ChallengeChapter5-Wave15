package com.rodan.challengechapter5_wave15.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.rodan.challengechapter5_wave15.R
import com.rodan.challengechapter5_wave15.databinding.DialogMenuBinding
import kotlin.random.Random


class MenuDialog : DialogFragment() {
    private lateinit var binding: DialogMenuBinding

    private var listener: OnMenuSelectedListener? = null

    fun setOnMenuSelectedListener(listener: OnMenuSelectedListener){
        this@MenuDialog.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setCanceledOnTouchOutside(false)

        binding.tvResult.apply {
            gameResult()
        }

        binding.btnPlayAgain.setOnClickListener{
            listener?.onPlayAgainClicked(this)
        }
        binding.btnBackToMenu.setOnClickListener {
            listener?.onBackToMenuClicked(this)
        }
    }

    fun gameResult(){
        val computerChoice = Random.nextInt(3)
        when (computerChoice){
            0 -> Toast.makeText(requireContext(), "lawan memilih batu", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(requireContext(), "lawan memilih kertas", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(requireContext(), "lawan memilih gunting", Toast.LENGTH_SHORT).show()
        }
        when(computerChoice){
            0 -> binding.tvResult.text = getString(R.string.draw)
            1 -> binding.tvResult.text = getString(R.string.cpu_win)
            2 -> binding.tvResult.text = getString(R.string.player_1_win)
        }
    }

    companion object{
        const val EXTRA_RESULT = "EXTRA_RESULT"

        fun newInstance(nameParam: String) {
            MenuDialog().apply {
                Bundle().apply {
                    putString(EXTRA_RESULT,nameParam)
                }
            }
        }
    }
}

interface OnMenuSelectedListener{
    fun onPlayAgainClicked(dialog: DialogFragment)
    fun onBackToMenuClicked(dialog: DialogFragment)
}