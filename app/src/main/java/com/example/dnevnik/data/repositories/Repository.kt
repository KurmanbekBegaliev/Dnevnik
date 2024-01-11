package com.example.ejournal.data.repositories

import com.example.ejournal.data.remote.ApiService
import com.example.ejournal.tools.UiState
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getPupils() = flow {
        emit(UiState.Loading())
        val response = apiService.getTeachers()
        if (response.isSuccessful) {
            emit(UiState.Success(response.body()))
        } else {
            emit(UiState.Error(response.message()))
        }

    }
}