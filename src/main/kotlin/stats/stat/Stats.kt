package stats.stat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Stats(
    var strength: MutableState<Int>,
    var intellect: MutableState<Int>,
    var toughness: MutableState<Int>,
    var dexterity: MutableState<Int>,
    var maxStamina: MutableState<Float>,
    var maxHealth: MutableState<Float>
) {
    constructor(
        allStats: Int,
        maxHealth: Float,
        maxStamina: Float
    ) : this(
        strength = mutableStateOf(allStats),
        dexterity = mutableStateOf(allStats),
        intellect = mutableStateOf(allStats),
        toughness = mutableStateOf(allStats),
        maxStamina = mutableStateOf(maxStamina),
        maxHealth = mutableStateOf(maxHealth)
    )

    constructor() : this(
        10,
        100f,
        100f
    )
}