
class Application(filename: String) {
    fun run() {
        println("Hello, world!")
    }
}

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        Application(args[0]).run()
    } else {
        throw IllegalArgumentException("missing arguments")
    }
}