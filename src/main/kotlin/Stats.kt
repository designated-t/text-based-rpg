import androidx.compose.runtime.MutableState

data class Stats(
    var strength: MutableState<Int>,
    var intellect: MutableState<Int>,
    var toughness: MutableState<Int>,
    var dexterity: MutableState<Int>,
)