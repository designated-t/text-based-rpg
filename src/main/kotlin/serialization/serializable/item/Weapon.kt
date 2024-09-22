package serialization.serializable.item

import stats.damage.DamageModifiers

data class Weapon(
    override val id: String,
    override val baseDamage: Float,
    override val name: String,
    override val type: String,
    val modifiers: DamageModifiers
) : BaseWeapon
