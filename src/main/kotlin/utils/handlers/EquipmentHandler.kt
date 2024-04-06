package utils.handlers

import utils.characters.Entity
import utils.characters.Equipment
import utils.items.Item
import utils.items.ItemType

class EquipmentHandler(
    private val entityToHandle: Entity
) {
    fun changeItem(item: Item) {
        removeItem(item, item.type)
        equip(item, item.type)
    }

    private fun equip(item: Item?, itemType: ItemType) {
        Equipment::class.java.getDeclaredMethod("${itemType.fieldName}Setter").invoke(entityToHandle.equipment, item)
    }

    fun removeItem(item: Item?, itemType: ItemType) {
        if (item != null) {
            entityToHandle.inventory.add(item)
        }

        equip(null, itemType)
    }
}