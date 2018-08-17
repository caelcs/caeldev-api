import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.util.Lists
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CSVHandlerTests {

    @Test
    fun `should open a csv file when the filename is correct`() {
        //Given
        val filename = "test.csv"

        //When
        val entries = CSVHandler(filename).buildEntries(Transformers.groupByBrand)

        //Then
        assertThat(entries).isNotEmpty
        assertThat(entries).containsExactly(
                CustomerEntry("CLARIN", Lists.list( "adolfoecs@gmail.com")),
                CustomerEntry("INFOBAE", Lists.list("info.cael@gmail.com", "cael@gmail.com")))
    }

    @Test
    fun `should fail when the filename is not correct`() {
        //Given
        val filename = "invalid.csv"

        //When
        val exception = assertThrows(IllegalArgumentException::class.java) {
            CSVHandler(filename).buildEntries(Transformers.groupByBrand)
        }

        //Then
        assertThat(exception).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should fail when there is one field`() {
        //Given
        val filename = "test_one_field.csv"

        //When
        val exception = assertThrows(IllegalArgumentException::class.java) {
            CSVHandler(filename).buildEntries(Transformers.groupByBrand)
        }

        //Then
        assertThat(exception).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(exception.message).isEqualTo("CSV file should contains 2 fields at least")
    }
}