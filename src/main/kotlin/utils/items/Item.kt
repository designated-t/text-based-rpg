package utils.items

import kotlinx.serialization.Serializable
import utils.Requirement
import utils.properties.IProperties

@Serializable(with = ItemSerializer::class)
interface Item {
    val name: String
    val description: String
    val requirement: Requirement
    val type: ItemType
    val properties: IProperties
}
