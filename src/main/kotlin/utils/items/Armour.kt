package utils.items

import kotlinx.serialization.Serializable
import utils.Requirement
import utils.properties.ArmourProperties

@Serializable
data class Armour(
    override val name: String,
    override val description: String,
    override val type: ItemType,
    override val requirement: Requirement,
    override val properties: ArmourProperties
) : Item