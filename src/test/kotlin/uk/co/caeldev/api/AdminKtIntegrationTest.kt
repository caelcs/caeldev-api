package uk.co.caeldev.api

import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.koin.test.AutoCloseKoinTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

internal class AdminKtIntegrationTest: AutoCloseKoinTest() {

    @Test
    fun `health check endpoint should return success`(): Unit = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/health")) {
            assertEquals("OK", response.content)
            assertEquals(HttpStatusCode.OK, response.status())
        }
    }

    @Test
    fun `metrics endpoint shuold return success`(): Unit = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/metrics")) {
            assertFalse(response.content.isNullOrBlank())
            assertEquals(HttpStatusCode.OK, response.status())
        }
    }
}