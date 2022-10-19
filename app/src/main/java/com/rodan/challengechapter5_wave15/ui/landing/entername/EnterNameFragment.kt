package com.rodan.challengechapter5_wave15.ui.landing.entername

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rodan.challengechapter5_wave15.databinding.FragmentEnterNameBinding
import com.rodan.challengechapter5_wave15.ui.landing.OnFinishNavigate
import com.rodan.challengechapter5_wave15.ui.menu.MenuPageActivity


class EnterNameFragment : Fragment(), OnFinishNavigate {

    lateinit var binding: FragmentEnterNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEnterNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onFinishNavigate() {
        val editTextName = binding.etWriteYourName.text.toString().trim()
        if (editTextName.isEmpty()){
            Toast.makeText(requireContext(), "Input nama Anda", Toast.LENGTH_SHORT).show()
        }else{
            navigateToMenuPage(editTextName)
        }
    }

    fun navigateToMenuPage(name:String){
        MenuPageActivity.startActivity(requireContext(),name)
    }
}