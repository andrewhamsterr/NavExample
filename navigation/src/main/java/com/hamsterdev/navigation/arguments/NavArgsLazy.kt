package com.hamsterdev.navigation.arguments


import android.os.Bundle
import kotlin.reflect.KClass

class NavArgsLazy<Args : Arguments>(
    private val argumentProducer: () -> Bundle

) : Lazy<Args> {
    private var cached: Args? = null

    override val value: Args
        get() {
            var args = cached
            if (args == null) {
                args = argumentProducer().getParcelable(Arguments.BUNDLE_KEY)
                cached = args
            }
            return args ?: throw IllegalStateException("No arguments found")
        }

    override fun isInitialized(): Boolean = cached != null
}