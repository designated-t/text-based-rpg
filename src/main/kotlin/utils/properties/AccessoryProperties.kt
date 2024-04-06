package utils.properties

import kotlinx.serialization.Serializable

@Serializable
data class AccessoryProperties(
    override val stats: Stats
) : IProperties