
typealias BaseStep<T> = (source: List<CustomerEntry>) -> List<T>

class SQLGenerator(val stepValidateEmail: BaseStep<CustomerEntry> = { source1: List<CustomerEntry> -> validateEmails(source1)},
                   val stepValidateEntitlement: BaseStep<CustomerEntry> = { source1: List<CustomerEntry> -> validateEntitlement(source1)},
                   val stepGenerateScripts: BaseStep<String> = { source1: List<CustomerEntry> -> generateScripts(source1)}) {

    fun scriptGenerator(entries: List<CustomerEntry>): List<String> {
        val validEmails = stepValidateEmail(entries)
        val entitledEmails = stepValidateEntitlement(validEmails)
        return stepGenerateScripts(entitledEmails)
    }
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

