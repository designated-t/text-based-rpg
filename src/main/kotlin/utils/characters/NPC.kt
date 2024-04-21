package utils.characters

import kotlinx.serialization.Serializable
import utils.items.Item
import utils.properties.EntityProperties
import utils.quests.QuestTrigger

@Serializable
data class NPC(
    override val id: String,
    override val name: String,
    override val description: String,
    val dialogues: Collection<String>,
    val relatedQuests: Collection<QuestTrigger> = emptyList(),
    override val properties: EntityProperties = EntityProperties(),
    override val equipment: Equipment = Equipment(),
    override val inventory: MutableCollection<Item> = mutableListOf(),
) : Entity
