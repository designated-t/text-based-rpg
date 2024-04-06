package utils.properties

import kotlinx.serialization.Serializable

@Serializable
data class ArmourProperties(
    val defense: Int,
    override val stats: Stats
) : IProperties
