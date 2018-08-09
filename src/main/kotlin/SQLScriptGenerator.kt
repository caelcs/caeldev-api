
object SQLScriptGenerator {

    fun generate(stepValidateEmail: (source: List<CustomerEntry>) -> List<CustomerEntry> = { source1: List<CustomerEntry> -> validateEmails(source1)},
                 stepValidateEntitlement: (source: List<CustomerEntry>) -> List<CustomerEntry> = { source1: List<CustomerEntry> -> validateEntitlement(source1)},
                 stepGenerateScripts: (source: List<CustomerEntry>) -> List<String> = { source1: List<CustomerEntry> -> generateScripts(source1)},
                 entries: List<CustomerEntry>): List<String> {
        val validEmails = stepValidateEmail(entries)
        val entitledEmails = stepValidateEntitlement(validEmails)
        return stepGenerateScripts(entitledEmails)
    }

    internal inline fun validateEmails(source: List<CustomerEntry>): List<CustomerEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates. // }
    }

    internal inline fun validateEntitlement(source: List<CustomerEntry>): List<CustomerEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal inline fun generateScripts(source: List<CustomerEntry>): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}



