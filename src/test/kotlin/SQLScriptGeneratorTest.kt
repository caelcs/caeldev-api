import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test

internal class SQLScriptGeneratorTest {

    val step1 = mockk<BaseStep<CustomerEntry>>()
    val step2 = mockk<BaseStep<CustomerEntry>>()
    val step3 = mockk<BaseStep<String>>()

    @Test
    fun `should generate scripts`() {
        //Given
        val customerEntry = arrayListOf(
                CustomerEntry("brand1", arrayListOf(Pair("brand2", "info@gmail.com"))),
                CustomerEntry("brand2", arrayListOf(Pair("brand1", "info1.cael@gmail.com"))))

        //And
        val expectedFilteredEmails = arrayListOf(
                CustomerEntry("brand1", arrayListOf(Pair("brand2", "info@gmail.com"))))
        every { step1(customerEntry) } returns expectedFilteredEmails

        //and
        val expepectedEntitledEmails = Lists.emptyList<CustomerEntry>()
        every { step2(expectedFilteredEmails) } returns expepectedEntitledEmails

        //and
        val expectedScripts = Lists.emptyList<String>()
        every { step3(expepectedEntitledEmails) } returns expectedScripts

        //When
        val result = SQLGenerator(step1, step2, step3).scriptGenerator(customerEntry)

        //Then
        assertThat(result).isEmpty()
    }
}