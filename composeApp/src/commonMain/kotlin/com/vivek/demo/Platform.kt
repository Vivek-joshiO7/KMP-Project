package com.vivek.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform