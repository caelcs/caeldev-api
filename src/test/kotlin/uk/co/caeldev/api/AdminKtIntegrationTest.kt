package uk.co.caeldev.api

import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should not be null or blank`
import org.amshove.kluent.`should not be`
import org.koin.test.AutoCloseKoinTest
import kotlin.test.Test

internal class AdminKtIntegrationTest: AutoCloseKoinTest() {

    @Test
    fun `health check endpoint should return success`(): Unit = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/health")) {
            response.content.`should not be`("OK")
            response.status().`should be`(HttpStatusCode.OK)
        }
    }

    @Test
    fun `metrics endpoint shuold return success`(): Unit = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/metrics")) {
            response.content.`should not be null or blank`()
            response.status().`should be`(HttpStatusCode.OK)
        }
    }
}