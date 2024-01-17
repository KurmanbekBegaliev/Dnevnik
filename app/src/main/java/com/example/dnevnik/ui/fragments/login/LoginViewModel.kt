package com.example.dnevnik.ui.fragments.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dnevnik.data.models.Pupils
import com.example.ejournal.data.repositories.Repository
import com.example.ejournal.tools.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    init {
        getPupils()
    }

    private var _responseState = MutableStateFlow<UiState<Pupils>>(UiState.Empty())
    val responseState = _responseState.asStateFlow()

    private fun getPupils() = viewModelScope.launch {
        repository.getPupils().collect {
            _responseState.value = it
        }
    }
}