package serialization.serializable.map

import serialization.serializable.Identifiable
import kotlinx.serialization.Serializable
import serialization.serializers.ZoneSerializer

@Serializable(with = ZoneSerializer::class)
data class Zone(
    override val id: String,
    val name: String,
    val world: World
): Identifiable