package utils.items

import kotlinx.serialization.Serializable
import utils.Requirement
import utils.properties.WeaponProperties

@Serializable
data class Weapon(
    override val name: String,
    override val description: String,
    override val type: ItemType,
    override val requirement: Requirement = Requirement(),
    override val properties: WeaponProperties
) : Item
