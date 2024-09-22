package serialization.serializable.map

import serialization.serializable.Identifiable
import kotlinx.serialization.Serializable

@Serializable
data class World(
    val name: String,
    override val id: String
): Identifiable
