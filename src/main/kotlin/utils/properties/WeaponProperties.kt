package utils.properties

import kotlinx.serialization.Serializable

@Serializable
data class WeaponProperties(
    val damage: Int,
    override val stats: Stats = Stats()
) : IProperties
