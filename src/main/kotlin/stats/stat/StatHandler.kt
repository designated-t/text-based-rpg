package stats.stat

import enums.StatType

object StatHandler {

    /**
     * Multiplication of stats follows principle:
     * baseValue * (1f + sum of additiveMultipliers) * each multiplicativeMultiplier
     *
     * TODO: Broaden scope of stat types. Cost and Regen.
     */
    fun multiply(type: StatType, baseValue: Float, modifiers: StatModifiers): Float {
        val (additive, multiplicative) = modifiers.getMultiplierValues(type)

        val summedValue = baseValue * additive.plus(1f).sum()
        var multipliedValue = summedValue

        if (multiplicative.isEmpty())
            return summedValue
        else
            multiplicative.forEach {
                multipliedValue *= it
            }

        return multipliedValue
    }
}