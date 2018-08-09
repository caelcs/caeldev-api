import io.mockk.mockk
import org.junit.jupiter.api.Test

internal class SQLScriptGeneratorTest {

    val step1 = mockk<BaseStep<CustomerEntry>>()
    val step2 = mockk<BaseStep<CustomerEntry>>()
    val step3 = mockk<BaseStep<String>>()

    @Test
    fun `should generate scripts`() {

        //given
        val customerEntry = arrayListOf(
                CustomerEntry("brand1", arrayListOf(Pair("brand2", "info@gmail.com"))),
                CustomerEntry("brand2", arrayListOf(Pair("brand1", "info1.cael@gmail.com"))))
        //When
        val result = SQLGenerator(step1, step2, step3).scriptGenerator(customerEntry)

    }
}