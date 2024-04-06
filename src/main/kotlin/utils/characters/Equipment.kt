package utils.characters

import utils.items.Accessory
import utils.items.Armour
import utils.items.Item
import utils.items.Weapon


class Equipment {
    private var accessory: Accessory? = null
    private var chestArmour: Armour? = null
    private var legArmour: Armour? = null
    private var footArmour: Armour? = null
    private var headArmour: Armour? = null
    private var weapon: Weapon? = null

    fun weaponSetter(weapon: Weapon?) {
        this.weapon = weapon
    }

    fun chestArmourSetter(chestArmour: Armour?) {
        this.chestArmour = chestArmour
    }

    fun legArmourSetter(legArmour: Armour?) {
        this.legArmour = legArmour
    }

    fun footArmourSetter(footArmour: Armour?) {
        this.footArmour = footArmour
    }

    fun headArmourSetter(headArmour: Armour?) {
        this.headArmour = headArmour
    }

    fun accessorySetter(accessory: Accessory?) {
        this.accessory = accessory
    }
}