package com.anwar.alodoktertest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.anwar.alodoktertest.domain.Constants
import com.anwar.alodoktertest.utils.SPHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isLogin: Boolean = SPHelper.instance.getSharedPreferences(Constants.IS_LOGIN, false)

        Log.i("MAIN", "Is login --> $isLogin")

        showMainScreen()

    }

    private fun showMainScreen() {

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.i("MAIN", "Des --> ${controller.currentDestination?.label}")
            when (controller.currentDestination?.id) {
                R.id.navigation_home, R.id.navigation_profile -> {
                    nav_view.visibility = View.VISIBLE
                }
                else -> nav_view.visibility = View.GONE
            }
        }
    }
}
