
typealias BaseStep<T> = (source: List<CustomerEntry>) -> List<T>

class SQLGenerator(val stepValidateEmail: BaseStep<CustomerEntry> = Steps.step1,
                   val stepValidateEntitlement: BaseStep<CustomerEntry> = Steps.step2,
                   val stepGenerateScripts: BaseStep<String> = Steps.step3) {

    fun scriptGenerator(entries: List<CustomerEntry>): List<String> {
        val validEmails = stepValidateEmail(entries)
        val entitledEmails = stepValidateEntitlement(validEmails)
        return stepGenerateScripts(entitledEmails)
    }
}

object Steps {
    val step1 = { source1: List<CustomerEntry> -> validateEmails(source1) }
    val step2 = { source1: List<CustomerEntry> -> validateEntitlement(source1)}
    val step3 = { source1: List<CustomerEntry> -> generateScripts(source1) }
}

inline fun validateEmails(source: List<CustomerEntry>): List<CustomerEntry> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates. // }
}

inline fun validateEntitlement(source: List<CustomerEntry>): List<CustomerEntry> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

inline fun generateScripts(source: List<CustomerEntry>): List<String> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

