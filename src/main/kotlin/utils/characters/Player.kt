package utils.characters

import utils.handlers.EquipmentHandler
import utils.items.Item
import utils.properties.EntityProperties
import utils.properties.Stats

class Player(
    override val properties: EntityProperties = EntityProperties(
        baseHealth = 10,
        speed = 2,
        stats = Stats(
            intelligence = 3,
            strength = 5,
            stamina = 3,
            dexterity = 5
        )
    ),
    override val equipment: Equipment,
    override val inventory: MutableCollection<Item>,
    override val id: String = "player",
    override val name: String = "Player"
): Entity {

    private val equipmentHandler: EquipmentHandler = EquipmentHandler(this)

    fun equip(item: Item) {
        equipmentHandler.changeItem(item)
    }

    fun unequip(item: Item) {
        equipmentHandler.removeItem(item, item.type)
    }
}