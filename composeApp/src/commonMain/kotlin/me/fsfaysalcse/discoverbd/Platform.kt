package me.fsfaysalcse.discoverbd

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform