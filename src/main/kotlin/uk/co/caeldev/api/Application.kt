package uk.co.caeldev.api


import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Locations
import io.ktor.request.path
import io.ktor.response.respond
import io.ktor.routing.routing
import org.slf4j.event.Level

fun Application.main() {
    install(DefaultHeaders)
    install(ConditionalHeaders)
    install(Locations)
    install(Compression)

    install(StatusPages) {
        exception<NotImplementedError> { call.respond(HttpStatusCode.NotImplemented) }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    routing {
        admin()
    }
}

