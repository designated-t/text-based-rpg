package utils.maps

import kotlinx.serialization.Serializable
import utils.Requirement

//TODO: Make custom serializer for this to properly service Connector
@Serializable
data class Zone(
    val id: String,
    val name: String,
    val description: String,
    val requirement: Requirement = Requirement(),
    val connector: Connector = Connector(),
    val npcs: Collection<String> = emptyList(),
    val monsters: Collection<String> = emptyList()
)