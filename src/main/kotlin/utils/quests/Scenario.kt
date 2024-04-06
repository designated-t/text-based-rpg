package utils.quests

import kotlinx.serialization.Serializable
import utils.Requirement

@Serializable
data class Scenario(
    val name: String,
    val description: String,
    val prelude: String,
    val relevance: Relevance,
    val quests: Collection<Quest>
)
