package com.example.dnevnik.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dnevnik.R
import com.example.dnevnik.databinding.ActivityMainBinding
import com.example.ejournal.tools.viewVisibility
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHost.navController

        setSupportActionBar(binding.mainToolbar)
        setupBar()

    }

    private fun setupBar() {
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.scheduleFragment,
                R.id.visitFragment,
                R.id.profileFragment,
            )
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.loginFragment) {
                supportActionBar?.hide()
                binding.navView.viewVisibility(false)
            } else {
                supportActionBar?.show()
                binding.navView.viewVisibility(true)
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }
}