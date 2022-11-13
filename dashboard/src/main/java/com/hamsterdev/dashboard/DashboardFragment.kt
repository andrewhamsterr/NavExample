package com.hamsterdev.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hamsterdev.dashboard.databinding.FragmentDashboardBinding
import com.hamsterdev.navigation.actions.DashboardArgs
import com.hamsterdev.navigation.ext.navArgs

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val args by navArgs<DashboardArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDashboardBinding.bind(view)
        binding.text2.text = args.someText
    }
}