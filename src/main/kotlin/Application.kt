class Application(val filename: String) {
    fun run() {
        val entries = CSVHandler(filename).buildEntries { entries: List<CustomerEntry> -> groupByBrand(entries)}
        val sqlScripts = SQLGenerator()
                .scriptGenerator(entries = entries)

        println(sqlScripts)
    }
}

fun main(args: Array<String>) {
    require(args.isNotEmpty())
    Application(args[0]).run()
}