package chat.ramble.domain.model

data class BatterySnapshot(
    val batteryLevel: Int,
    val timestampMs: Long,
)
