package com.hamsterdev.navigation.actions

import androidx.annotation.IdRes
import com.hamsterdev.navigation.arguments.Arguments

sealed class BaseAction(
    @IdRes val id: Int,
    val arguments: Arguments? = null
)