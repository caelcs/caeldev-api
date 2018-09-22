class Application() {
    fun run() {
        println("hello world")
    }
}

fun main(args: Array<String>) {
    require(args.isNotEmpty())
    Application().run()
}