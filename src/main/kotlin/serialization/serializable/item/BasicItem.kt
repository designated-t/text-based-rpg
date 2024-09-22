package serialization.serializable.item

data class BasicItem(
    override val name: String,
    override val type: String,
    override val id: String
) : BaseItem
