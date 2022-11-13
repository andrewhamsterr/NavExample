package com.hamsterdev.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hamsterdev.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    val viewModel by viewModels<HomeViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })

        binding.button.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHomeFragment2(""))
        }

    }
}