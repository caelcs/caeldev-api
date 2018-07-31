class Application(val filename: String) {
    fun run() {
        val entries = CSVHandler(filename).readEntries()
        println(entries)
    }
}

fun main(args: Array<String>) {
    require(args.isNotEmpty())
    Application(args[0]).run()
}