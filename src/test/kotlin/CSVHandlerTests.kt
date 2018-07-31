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
        val entries = CSVHandler(filename).readEntries()

        //Then
        assertThat(entries).isNotEmpty
        assertThat(entries).containsExactly(
                CustomerEntry("CLARIN", Lists.list(Pair( "adolfoecs@gmail.com", "CLARIN"))),
                CustomerEntry("INFOBAE", Lists.list(Pair( "info.cael@gmail.com", "INFOBAE"), Pair( "cael@gmail.com", "INFOBAE"))))
    }

    @Test
    fun `should fail when the filename is not correct`() {
        //Given
        val filename = "invalid.csv"

        //When
        val exception = assertThrows(IllegalArgumentException::class.java) {
            CSVHandler(filename).readEntries()
        }

        //Then
        assertThat(exception).isInstanceOf(IllegalArgumentException::class.java)
    }
}