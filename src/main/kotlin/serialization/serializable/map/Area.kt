package serialization.serializable.map

import serialization.serializable.Identifiable
import kotlinx.serialization.Serializable
import serialization.serializers.AreaSerializer

@Serializable(with = AreaSerializer::class)
data class Area(
    override val id: String,
    val name: String,
    val zone: Zone
): Identifiable
