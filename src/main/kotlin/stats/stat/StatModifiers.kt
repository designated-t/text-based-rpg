package stats.stat

import enums.Origin
import enums.StatType
import java.util.EnumMap

const val MODIFIER_DIVIDER = 100f

class StatModifiers {

    // TODO: Rearrange to make less maps of the largest Enums
    private val multipliers: EnumMap<MultiplierType, EnumMap<StatType, MutableList<Multiplier>>> = EnumMap(
        MultiplierType::class.java
    )

    init {
        MultiplierType
            .entries
            .forEach { multiType ->
                multipliers[multiType] = EnumMap(StatType::class.java)
                StatType
                    .entries
                    .forEach { statType ->
                        multipliers[multiType]!![statType] = mutableListOf()
                    }
            }
    }

    fun addMultiplier(origin: Origin, percentage: Int, statType: StatType, multiplierType: MultiplierType) =
        Multiplier(
            origin = origin,
            modifier = (percentage / MODIFIER_DIVIDER) + multiplierType.baseMulti
        ).apply {
            multipliers[multiplierType]!![statType]!!.add(this)
        }

    fun getMultiplierValues(statType: StatType) =
        Pair(
            multipliers[MultiplierType.MULTIPLICATIVE]!![statType]!!.map { it.modifier },
            multipliers[MultiplierType.ADDITIVE]!![statType]!!.map { it.modifier },
        )
}

data class Multiplier(
    val origin: Origin,
    val modifier: Float
)

enum class MultiplierType(val baseMulti: Float) {
    MULTIPLICATIVE(1f),
    ADDITIVE(0f)

    ;
}
