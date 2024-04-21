package utils.characters

import kotlinx.serialization.Serializable
import utils.items.Item
import utils.properties.EntityProperties

@Serializable
data class Monster(
    override val id: String,
    override val name: String,
    override val description: String,
    override val properties: EntityProperties,
    override val equipment: Equipment = Equipment(),
    override val inventory: MutableCollection<Item> = mutableListOf(),
) : Entity
