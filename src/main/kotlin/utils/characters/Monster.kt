package utils.characters

import utils.items.Item
import utils.properties.EntityProperties

data class Monster(
    override val id: String,
    override val properties: EntityProperties,
    override val equipment: Equipment,
    override val inventory: MutableCollection<Item>,
    override val name: String

) : Entity
