class SQLScriptGenerator {

    private val stepValidateEmail = StepFactory.get<CustomerEntry>(StepName.VALIDATE_EMAILS)
    private val stepValidateEntitlement = StepFactory.get<CustomerEntry>(StepName.VALIDATE_ENTITLEMENTS)
    private val generateScripts = StepFactory.get<String>(StepName.GENERATE_SCRIPTS)
    
    fun generate(entries: List<CustomerEntry>): List<String> {
        val validEmails = stepValidateEmail.execute(entries)
        val entitledEmails = stepValidateEntitlement.execute(validEmails)
        return generateScripts.execute(entitledEmails)
    }

}

object StepFactory {

    private val steps: Map<StepName, Step<Any>> = mapOf(Pair(StepName.VALIDATE_EMAILS, EmailAddressVerifyStep()),
            Pair(StepName.VALIDATE_ENTITLEMENTS, EntitlementVerifyStep()),
            Pair(StepName.GENERATE_SCRIPTS, GenerateSQLScriptsStep()))

    fun <T> get(stepName: StepName): Step<T> {
        return steps[stepName]as Step<T>
    }
}

enum class StepName {
    VALIDATE_EMAILS, VALIDATE_ENTITLEMENTS, GENERATE_SCRIPTS
}

interface Step<out T> {

    fun execute(source: List<CustomerEntry>): List<T>

}

class EmailAddressVerifyStep: Step<CustomerEntry> {

    override fun execute(source: List<CustomerEntry>): List<CustomerEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class EntitlementVerifyStep: Step<CustomerEntry> {

    override fun execute(source: List<CustomerEntry>): List<CustomerEntry> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class GenerateSQLScriptsStep: Step<String> {

    override fun execute(source: List<CustomerEntry>): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}