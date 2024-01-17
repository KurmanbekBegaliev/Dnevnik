package com.example.dnevnik.ui.fragments.profile

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.dnevnik.R
import com.example.dnevnik.base.BaseFragment
import com.example.dnevnik.data.models.Pupils
import com.example.dnevnik.data.models.PupilsItem
import com.example.dnevnik.databinding.FragmentProfileBinding
import com.example.ejournal.data.local.PreferencesHelper
import com.example.ejournal.tools.UiState
import com.example.ejournal.tools.setImage
import com.example.ejournal.tools.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    override val viewModel: ProfileViewModel by viewModels()

    private val preferencesHelper by lazy {
        PreferencesHelper(requireContext())
    }

    override fun setupListeners() {
        binding.btnLogout.setOnClickListener {
            preferencesHelper.userId = 0
            preferencesHelper.isLoginSuccess = false
            findNavController().navigate(R.id.loginFragment)
        }
    }
    override fun setupSubscribes() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.responseState.collect {
                    when (it) {
                        is UiState.Empty -> {}
                        is UiState.Error -> {
                            showToast(it.msg)
                        }

                        is UiState.Loading -> {}
                        is UiState.Success -> {
                            it.data?.let { it1 -> showWithId(it1) }
                        }
                    }
                }
            }
        }
    }

    private fun showWithId(pupils: ArrayList<PupilsItem>) {
        val id = preferencesHelper.userId

        for (i in pupils) {
            if (id == i.id) {
                binding.tvUserFio.text = i.fio
                binding.tvUserNumber.text = i.phone
                binding.tvUserEmail.text = i.email
                i.avatar?.let { binding.imgUserAvatar.setImage(it) }
            }
        }
    }

}