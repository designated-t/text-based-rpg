package utils.quests

import kotlinx.serialization.Serializable
import utils.quests.Scenario

@Serializable
data class Story(
    val scenarios:Collection<Scenario>
)
