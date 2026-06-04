package com.sargis.khlopuzyan.cmpmobilebanking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform