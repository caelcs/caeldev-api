import java.io.File

class CSVHandler(filename: String) {

    private val entries: List<CustomerEntry>

    init {
        val csvFile = openFile(filename)
        val lines = csvFile.readLines()
        this.entries = this.buildEntries(lines)
    }

    private fun buildEntries(lines: List<String>): List<CustomerEntry> {
        return lines.map {
            val fields = it.split(",")
            require(fields.size == 2, {"CSV file shuold contains 2 fields at least"})
            val email = fields[0]
            val brand = fields[1]
            Pair(email, brand)
        }.groupBy { it.second }.map { CustomerEntry(it.key, it.value) }.toList()
    }

    private fun openFile(filename: String): File = try { File(ClassLoader.getSystemResource(filename).file) } catch(ex: Exception) { throw IllegalArgumentException("file $filename not found") }

    fun readEntries(): List<CustomerEntry> {
        return entries
    }
}

data class CustomerEntry(val brand: String,
                         val entries: List<Pair<String, String>>)