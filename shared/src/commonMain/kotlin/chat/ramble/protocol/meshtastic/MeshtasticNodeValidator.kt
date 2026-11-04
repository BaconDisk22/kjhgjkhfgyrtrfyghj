package chat.ramble.protocol.meshtastic

sealed class ValidationResult {
    object Valid : ValidationResult()
    data class InvalidRole(val role: String) : ValidationResult()
    object Unmessageable : ValidationResult()
}

object MeshtasticNodeValidator {
    private val VALID_ROLES = setOf("CLIENT", "CLIENT_MUTE")

    fun validate(role: String, isUnmessageable: Boolean): ValidationResult = when {
        isUnmessageable -> ValidationResult.Unmessageable
        role !in VALID_ROLES -> ValidationResult.InvalidRole(role)
        else -> ValidationResult.Valid
    }
}
