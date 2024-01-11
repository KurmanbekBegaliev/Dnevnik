package com.example.ejournal.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelper @Inject constructor(context: Context){

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
    var isLoginSuccess: Boolean
        set(value) = sharedPreferences.edit().putBoolean("LOGIN_KEY", value).apply()
        get() = sharedPreferences.getBoolean("LOGIN_KEY", false)
}