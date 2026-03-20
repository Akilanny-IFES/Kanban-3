package com.akilanny.task.ui

import DoneFragment
import TodoFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akilanny.task.R
import com.akilanny.task.databinding.FragmentHomeBinding
import com.akilanny.task.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTabs()
    }

    private fun initTabs() {
        val adapter = ViewPagerAdapter(requireActivity())

        binding.viewPager.adapter = adapter
        adapter.addFragment(TodoFragment(), R.string.status_task_todo)
        adapter.addFragment(DoingFragment(), R.string.status_doing)
        adapter.addFragment(DoneFragment(), R.string.status_done)

        binding.viewPager.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = getString(adapter.getTitle(position))
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
