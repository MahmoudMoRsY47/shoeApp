package com.example.shoestoreapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentAddNewShoeBinding
import com.example.shoestoreapp.viewmodel.ShoeViewModel
import com.google.android.material.snackbar.Snackbar


class AddNewShoeFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    lateinit var binding : FragmentAddNewShoeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_shoe, container, false)

        binding.viewModel= viewModel

        // save button
        binding.saveButton.setOnClickListener {

            if (viewModel.addShoe()) {

                val action=AddNewShoeFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                findNavController().navigate(action)


            } else {
                Snackbar.make(
                    requireView(),
                    "Enter all filed",
                    Snackbar.LENGTH_LONG)
                    .show()
            }
        }

        // cancel button
        binding.cancelButton.setOnClickListener {
            val action=AddNewShoeFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            findNavController().navigate(action)

        }


        return binding.root
    }
}