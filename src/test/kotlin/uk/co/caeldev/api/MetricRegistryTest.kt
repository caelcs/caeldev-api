package uk.co.caeldev.api

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class MetricRegistryTest {

    @Test
    fun `should construct successfully`() {
        //When
        val result = MetricRegistry().getMetrics()

        //Then
        assertTrue(result.isNotBlank())
    }
}