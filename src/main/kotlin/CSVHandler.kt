import java.io.File

class CSVHandler(filename: String) {

    private val lines: List<String>

    init {
        lines = openFile(filename)
                .readLines()
    }

    fun buildEntries(transform: (entries: List<CustomerEntry>) -> List<CustomerEntry> = { entries1: List<CustomerEntry> -> entries1}): List<CustomerEntry> {
        val entriesFiltered = lines.map {
            val fields = it.split(",")
            require(fields.size == 2, { "CSV file should contains 2 fields at least" })
            val email = fields[0]
            val brand = fields[1]
            CustomerEntry(brand, listOf(email))
        }.toList()
        return transform(entriesFiltered)
    }

    private fun openFile(filename: String): File {
        try {
            return File(ClassLoader.getSystemResource(filename).file)
        } catch (ex: Throwable) {
            throw IllegalArgumentException("file $filename not found")
        }
    }
}

object Transformers {

    val groupByBrand = { entries: List<CustomerEntry> -> groupByBrand(entries) }
}

fun groupByBrand(entries: List<CustomerEntry>): List<CustomerEntry> {
    return entries.groupBy { it.brand }
            .map { customer ->
                CustomerEntry(customer.key, customer.value.flatMap { it.emails })
            }.toList()
}

data class CustomerEntry(val brand: String, val emails: List<String>)