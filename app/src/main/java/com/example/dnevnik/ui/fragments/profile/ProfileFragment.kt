package com.example.dnevnik.ui.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dnevnik.R
import com.example.dnevnik.base.BaseFragment
import com.example.dnevnik.databinding.FragmentProfileBinding
import com.example.ejournal.tools.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override fun getViewBinding(): FragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater)

    override val viewModel: ProfileViewModel by viewModels()

    override fun initialize() {
        binding.imgUserAvatar.setImage("https://studentapi2002.pythonanywhere.com/media/photo/2023/12/22/WhatsApp_Image_2023-12-19_at_20.34.37-removebg-preview.png")
    }

}