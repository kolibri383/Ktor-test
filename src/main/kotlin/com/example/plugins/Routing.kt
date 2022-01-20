package com.example.plugins


import com.example.Service.AuthorService
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.koin.java.KoinJavaComponent.inject



fun Application.configureRouting() {

    val authorService by inject<AuthorService>(AuthorService::class.java )

    routing {
        get("/author") {
            val authors = authorService.getAll()
            call.respondText("${authors[0].lastName} ${authors[0].firstName}")
        }
        get("/author/{id}"){
            val id = call.parameters["id"]?.toIntOrNull()
            if(id!=null)
                call.respondText(authorService.getById(id)?.firstName!!)
        }
    }
    routing {
    }
}


