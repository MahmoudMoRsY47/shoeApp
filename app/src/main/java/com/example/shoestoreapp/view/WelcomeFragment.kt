package com.example.shoestoreapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentLoginBinding
import com.example.shoestoreapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    lateinit var binding : FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.nextButton.setOnClickListener {
           val action=WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }
}