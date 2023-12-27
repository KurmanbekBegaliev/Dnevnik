package com.example.dnevnik.ui.fragments.schedule.scheduleExplore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.dnevnik.R
import com.example.dnevnik.base.BaseFragment
import com.example.dnevnik.databinding.FragmentScheduleExploreBinding
import com.example.dnevnik.ui.fragments.schedule.adapters.ScheduleExploreAdapter


class ScheduleExploreFragment :
    BaseFragment<FragmentScheduleExploreBinding, ScheduleExploreViewModel>() {
    override fun getViewBinding(): FragmentScheduleExploreBinding =
        FragmentScheduleExploreBinding.inflate(layoutInflater)

    private lateinit var adapter: ScheduleExploreAdapter

    override val viewModel: ScheduleExploreViewModel
        get() = TODO("Not yet implemented")

    override fun initialize() {
        adapter = ScheduleExploreAdapter()
        binding.rvSchedule.adapter = adapter
    }

}