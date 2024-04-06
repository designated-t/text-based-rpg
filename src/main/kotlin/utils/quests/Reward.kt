package utils.quests

import kotlinx.serialization.Serializable
import utils.items.Item

@Serializable
data class Reward(
    val experience: Int = 0,
    val money: Int = 0,
    val items: Collection<Item> = emptyList()
)
