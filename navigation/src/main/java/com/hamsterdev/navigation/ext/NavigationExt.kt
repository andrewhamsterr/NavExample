package com.hamsterdev.navigation.ext

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.hamsterdev.navigation.actions.BaseAction
import com.hamsterdev.navigation.arguments.Arguments
import com.hamsterdev.navigation.arguments.NavArgsLazy

fun NavController.navigateGlobal(action: BaseAction, navOptions: NavOptions? = null) {
    this.navigate(action.id, action.arguments?.toBundle(), navOptions)
}
@MainThread
inline fun <reified Args : Arguments> Fragment.navArgs(): NavArgsLazy<Args> =
    NavArgsLazy {
        arguments ?: throw IllegalStateException("Fragment $this has null arguments")
    }
