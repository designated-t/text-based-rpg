package serialization.serializable.item

import kotlinx.serialization.Serializable

@Serializable
data class BasicItem(
    override val name: String,
    override val type: String,
    override val id: String
) : BaseItem
