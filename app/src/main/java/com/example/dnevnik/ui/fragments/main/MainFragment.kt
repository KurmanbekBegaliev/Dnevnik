package com.example.dnevnik.ui.fragments.main

import com.example.dnevnik.base.BaseFragment
import com.example.dnevnik.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override fun getViewBinding(): FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)

    override val viewModel: MainViewModel
        get() = TODO("Not yet implemented")

    override fun initialize() {
        binding.rvNews.adapter = NewsAdapter()
    }
}