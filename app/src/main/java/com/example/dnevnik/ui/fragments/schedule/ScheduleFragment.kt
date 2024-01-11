package com.example.dnevnik.ui.fragments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.dnevnik.databinding.FragmentScheduleBinding
import com.example.dnevnik.ui.fragments.schedule.adapters.ScheduleExploreViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    private lateinit var binding : FragmentScheduleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScheduleBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabTitles = arrayListOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ")

        binding.viewPagerMain.adapter = ScheduleExploreViewPagerAdapter(this@ScheduleFragment)
        binding.viewPagerMain.isSaveEnabled = true

        TabLayoutMediator(binding.tabLayout, binding.viewPagerMain) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }

}