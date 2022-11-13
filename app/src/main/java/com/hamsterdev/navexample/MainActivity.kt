package com.hamsterdev.navexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import com.hamsterdev.navexample.databinding.ActivityMainBinding
import com.hamsterdev.navigation.actions.DashboardArgs
import com.hamsterdev.navigation.actions.ToDashboardAction
import com.hamsterdev.navigation.actions.ToHome
import com.hamsterdev.navigation.actions.ToNotifications
import com.hamsterdev.navigation.ext.navigateGlobal


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                com.hamsterdev.navigation.R.id.homeFragment -> {
                    binding?.bottomNavBar?.selectedItemId = R.id.home
                }
                com.hamsterdev.navigation.R.id.dashboardFragment -> {
                    binding?.bottomNavBar?.selectedItemId = R.id.dashboard

                }
                com.hamsterdev.navigation.R.id.notificationsFragment -> {
                    binding?.bottomNavBar?.selectedItemId = R.id.notifications
                }
                else -> {
                    null
                }
            }
            setNavBarVisibility(destination.id)
        }

        binding?.bottomNavBar?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    if (navController.currentDestination?.id != com.hamsterdev.navigation.R.id.homeFragment)
                        navController.navigateGlobal(ToHome(), navOptions {
                            popUpTo(com.hamsterdev.navigation.R.id.homeFragment) {
                                this.inclusive = false
                            }
                        })
                }
                R.id.dashboard -> {
                    if (navController.currentDestination?.id != com.hamsterdev.navigation.R.id.dashboardFragment)
                        navController.navigateGlobal(
                            ToDashboardAction(DashboardArgs("С навбара")),
                            navOptions {
                                popUpTo(com.hamsterdev.navigation.R.id.homeFragment) {
                                    this.inclusive = false
                                }
                            })
                }

                R.id.notifications -> {
                    if (navController.currentDestination?.id != com.hamsterdev.navigation.R.id.notificationsFragment)
                        navController.navigateGlobal(ToNotifications(), navOptions {
                            popUpTo(com.hamsterdev.navigation.R.id.homeFragment) {
                                this.inclusive = false
                            }
                        })
                }
            }
            true
        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun setNavBarVisibility(id: Int) {
        if (id in listOf(
                com.hamsterdev.navigation.R.id.homeFragment,
                com.hamsterdev.navigation.R.id.dashboardFragment,
                com.hamsterdev.navigation.R.id.notificationsFragment
            )
        ) {
            binding?.container?.transitionToStart()
        } else {
            binding?.container?.transitionToEnd()
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id !in MAIN_IDS)
            super.onBackPressed()
    }

    companion object {
        val MAIN_IDS = listOf(
            com.hamsterdev.navigation.R.id.homeFragment,
            com.hamsterdev.navigation.R.id.dashboardFragment,
            com.hamsterdev.navigation.R.id.notificationsFragment
        )
    }
}