package chat.ramble.protocol.meshcore

sealed class MeshCoreValidationResult {
    object Valid : MeshCoreValidationResult()
    data class InvalidRole(val role: String) : MeshCoreValidationResult()
}

object MeshCoreNodeValidator {
    fun validate(role: String): MeshCoreValidationResult = when (role.uppercase()) {
        "COMPANION" -> MeshCoreValidationResult.Valid
        else -> MeshCoreValidationResult.InvalidRole(role)
    }
}
