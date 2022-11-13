package com.hamsterdev.navigation.actions

import com.hamsterdev.navigation.R
import com.hamsterdev.navigation.arguments.Arguments
import kotlinx.parcelize.Parcelize

class ToDashboardAction(arguments: DashboardArgs) : BaseAction(R.id.action_to_dashboard, arguments)

@Parcelize
data class DashboardArgs(val someText: String) : Arguments