package me.fsfaysalcse.discoverbd.ui

import me.fsfaysalcse.discoverbd.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}