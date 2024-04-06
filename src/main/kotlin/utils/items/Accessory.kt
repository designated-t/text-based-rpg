package utils.items

import kotlinx.serialization.Serializable
import utils.Requirement
import utils.properties.AccessoryProperties

@Serializable
data class Accessory(
    override val name: String,
    override val description: String,
    override val requirement: Requirement,
    override val type: ItemType,
    override val properties: AccessoryProperties
) : Item
