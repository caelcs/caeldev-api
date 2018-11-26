package uk.co.caeldev.api

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.admin() {
    get("/health_check") {
        // Check databases/other services.
        call.respondText("OK")
    }
}