package utils.quests

import kotlinx.serialization.Serializable
import utils.Requirement

@Serializable
data class Quest(
    val id: String,
    val name: String,
    val description: String,
    val requirement: Requirement = Requirement(),
    val reward: Reward = Reward()
)
