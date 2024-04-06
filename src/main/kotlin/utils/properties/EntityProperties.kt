package utils.properties

import kotlinx.serialization.Serializable

@Serializable
data class EntityProperties(
    val level: Int = 1,
    val baseHealth: Int = 5,
    val bonusHealth: Int = 0,
    val defense: Int = 0,
    val speed: Int = 0,
    override val stats: Stats = Stats()
) : IProperties