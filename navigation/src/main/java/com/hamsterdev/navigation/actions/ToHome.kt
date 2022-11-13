package com.hamsterdev.navigation.actions

import android.os.Parcelable
import com.hamsterdev.navigation.R
import com.hamsterdev.navigation.arguments.Arguments
import kotlinx.parcelize.Parcelize

class ToHome(arguments: HomeArguments? = null) : BaseAction(id = R.id.action_to_home, arguments)

@Parcelize
data class HomeArguments(val refresh: Boolean) : Arguments, Parcelable