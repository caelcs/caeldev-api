
class SQLGenerator(val stepValidateEmail: (source: List<CustomerEntry>) -> List<CustomerEntry> = { source1: List<CustomerEntry> -> validateEmails(source1)},
                   val stepValidateEntitlement: (source: List<CustomerEntry>) -> List<CustomerEntry> = { source1: List<CustomerEntry> -> validateEntitlement(source1)},
                   val stepGenerateScripts: (source: List<CustomerEntry>) -> List<String> = { source1: List<CustomerEntry> -> generateScripts(source1)}) {

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

