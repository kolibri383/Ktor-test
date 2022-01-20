package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.koin.core.context.startKoin
import org.koin.logger.SLF4JLogger




fun main() {

    startKoin {
        SLF4JLogger()
        modules(authorModule)
    }
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)
}
