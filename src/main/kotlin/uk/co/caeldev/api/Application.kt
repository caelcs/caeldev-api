package uk.co.caeldev.api

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.request.path
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import org.slf4j.event.Level

fun Application.main() {
    install(StatusPages){
        exception<Throwable> { _ ->
            call.respond(HttpStatusCode.InternalServerError)
        }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    routing {
        root()
    }
}

// Extracted route
fun Routing.root() {
    get("/") {
        call.respondText("Hello World!")
    }

    get("/health_check") {
        // Check databases/other services.
        call.respondText("OK")
    }
}