package chat.ramble.domain.model

/** One stored inbound route, as the link picker reads it. */
data class InboundRoute(
    val contactId: String,
    val networkId: String?,
    /** Packet-flow order, contact to us: `[0]` is the sender's first hop. */
    val hops: List<String>,
)
