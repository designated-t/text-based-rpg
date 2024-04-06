package utils

import kotlinx.serialization.Serializable
import utils.properties.Stats

@Serializable
data class Requirement(
    val level: Int = 0,
    val quests: Collection<String> = emptyList(),
    val stats: Stats = Stats()
)
