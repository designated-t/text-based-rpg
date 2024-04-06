package utils.maps

import kotlinx.serialization.Serializable


@Serializable
data class World(
    val firstZone: String,
    val zones: Collection<Zone>
)