package com.hamsterdev.navigation.arguments

import android.os.Parcelable
import androidx.annotation.MainThread
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

interface Arguments : Parcelable {
    fun toBundle() =
        bundleOf(
            BUNDLE_KEY to this
        )

    companion object {
        const val BUNDLE_KEY = "ARGUMENTS_DATA"
    }

}

