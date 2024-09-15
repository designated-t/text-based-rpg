object StatHandler {

    /**
     * Multiplication of stats follows principle:
     * baseValue + (baseValue * sum of cumulativeMultipliers) * product of multiplicativeMultipliers
     */
    fun multiply(type: StatType, baseValue: Float, modifiers: Modifiers): Float {
        val (additive, multiplicative) = modifiers.getMultiplierValues(type)

        val summedValue = baseValue * additive.sum()
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