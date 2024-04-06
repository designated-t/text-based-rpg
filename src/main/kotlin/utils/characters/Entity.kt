package utils.characters

import kotlinx.serialization.Serializable
import utils.items.Item
import utils.properties.EntityProperties

@Serializable
sealed interface Entity {
    val id: String
    val name: String
    val properties: EntityProperties
    val equipment: Equipment
    val inventory: MutableCollection<Item>
}