package com.hamsterdev.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions
import com.hamsterdev.home.databinding.FragmentHome2Binding
import com.hamsterdev.navigation.actions.DashboardArgs
import com.hamsterdev.navigation.actions.ToDashboardAction
import com.hamsterdev.navigation.ext.navigateGlobal

class HomeFragment2 : Fragment() {

    private var _binding: FragmentHome2Binding? = null
    private val binding get() = _binding!!

    private val args by navArgs<HomeFragment2Args>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHome2Binding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.button.setOnClickListener {
            findNavController().navigateGlobal(
                action = ToDashboardAction(
                    arguments = DashboardArgs(someText = "Из другого модуля")
                ),
                navOptions = navOptions {
                    popUpTo(com.hamsterdev.navigation.R.id.homeFragment) { inclusive = false }
                })
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}