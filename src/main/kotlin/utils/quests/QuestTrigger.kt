package utils.quests

import kotlinx.serialization.Serializable

@Serializable
data class QuestTrigger(
    val id: String,
    val trigger: String,
    val denialOfTrigger: String,
    val dialogues: Collection<String>,
    var questAccepted: Boolean = false
)
