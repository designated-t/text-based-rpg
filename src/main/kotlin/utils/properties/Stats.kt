package utils.properties

import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    val intelligence: Int = 0,
    val strength: Int = 0,
    val stamina: Int = 0,
    val dexterity: Int = 0
)
