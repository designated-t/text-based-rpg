package stats.damage

import enums.DamageType
import enums.Origin
import java.util.EnumMap

const val MODIFIER_DIVIDER = 100f

// TODO: This shit can be generalized for Damage, Weapon and Stats
class DamageModifiers {
    private val multipliers: EnumMap<MultiplierType, EnumMap<DamageType, MutableList<Multiplier>>> = EnumMap(
        MultiplierType::class.java
    )

    init {
        MultiplierType
            .entries
            .forEach { multiType ->
                multipliers[multiType] = EnumMap(DamageType::class.java)
                DamageType
                    .entries
                    .forEach { statType ->
                        multipliers[multiType]!![statType] = mutableListOf()
                    }
            }
    }

    fun addMultiplier(origin: Origin, percentage: Int, type: DamageType, multiplierType: MultiplierType) =
        Multiplier(
            origin = origin,
            modifier = (percentage / MODIFIER_DIVIDER) + multiplierType.baseMulti
        ).apply {
            multipliers[multiplierType]!![type]!!.add(this)
        }

    fun getMultiplierValues(type: DamageType) =
        Pair(
            multipliers[MultiplierType.MULTIPLICATIVE]!![type]!!.map { it.modifier },
            multipliers[MultiplierType.ADDITIVE]!![type]!!.map { it.modifier },
        )
}

data class Multiplier(
    val origin: Origin,
    val modifier: Float
)

enum class MultiplierType(val baseMulti: Float) {
    MULTIPLICATIVE(0f),
    ADDITIVE(1f)

    ;
}
