package utils.items

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemType(
    val fieldName: String
) {
    @SerialName("weapon") WEAPON("weapon"),
    @SerialName("accessory") ACCESSORY("accessory"),
    @SerialName("chest_armour") CHEST_ARMOUR("chestArmour"),
    @SerialName("leg_armour") LEG_ARMOUR("legArmour"),
    @SerialName("foot_armour") FOOT_ARMOUR("footArmour"),
    @SerialName("head_armour") HEAD_ARMOUR("headArmour"),
}
