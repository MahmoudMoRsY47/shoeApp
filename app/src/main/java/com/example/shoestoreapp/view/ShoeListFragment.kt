package com.example.shoestoreapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreapp.R
import com.example.shoestoreapp.databinding.FragmentShoeListBinding
import com.example.shoestoreapp.databinding.ItemShoeBinding
import com.example.shoestoreapp.viewmodel.ShoeViewModel



class ShoeListFragment : Fragment() {

    lateinit var binding : FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.shoeList.removeAllViews()
            for (shoe in it) {
                addShoe(shoe.name,shoe.size,shoe.company,shoe.description)

            }
        }

        binding.addShoeButton.setOnClickListener {
            val action=ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_shoe_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_logout ->
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val bindingView = ItemShoeBinding.inflate(
            LayoutInflater.from(requireContext()),
            binding.shoeList,
            false
        )

        with(bindingView) {
            txtName.text = name
            txtSize.text=size.toString()
            txtCompony.text=company
            txtDes.text=description

        }
        binding.shoeList.addView(bindingView.root)
    }
}