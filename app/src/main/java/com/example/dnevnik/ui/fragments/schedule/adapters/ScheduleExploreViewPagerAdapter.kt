package com.example.dnevnik.ui.fragments.schedule.adapters

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dnevnik.ui.fragments.schedule.DaysOfTheWeek
import com.example.dnevnik.ui.fragments.schedule.scheduleExplore.ScheduleExploreFragment

class ScheduleExploreViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment.childFragmentManager, fragment.viewLifecycleOwner.lifecycle) {

    override fun getItemCount() = 6

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ScheduleExploreFragment().apply {
                arguments = bundleOf("BUNDLE_LESSON_TYPE" to DaysOfTheWeek.Monday)
            }

            1 -> ScheduleExploreFragment().apply {
                arguments = bundleOf("BUNDLE_LESSON_TYPE" to DaysOfTheWeek.Tuesday)
            }

            2 -> ScheduleExploreFragment().apply {
                arguments = bundleOf("BUNDLE_LESSON_TYPE" to DaysOfTheWeek.Wednesday)
            }

            3 -> ScheduleExploreFragment().apply {
                arguments = bundleOf("BUNDLE_LESSON_TYPE" to DaysOfTheWeek.Thursday)
            }

            4 -> ScheduleExploreFragment().apply {
                arguments = bundleOf("BUNDLE_LESSON_TYPE" to DaysOfTheWeek.Friday)
            }

            5 -> ScheduleExploreFragment().apply {
                arguments = bundleOf("BUNDLE_LESSON_TYPE" to DaysOfTheWeek.Saturday)
            }

            else -> throw IllegalStateException("Invalid position '$position'.")
        }
    }
}