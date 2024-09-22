import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import stats.stat.StatModifiers
import stats.stat.Stats

object Player {
    val inventory = mutableStateListOf<String>()
    var health = mutableStateOf(100f)
    var stamina = mutableStateOf(100f)
    var stats = Stats() // TODO: Check for need for this to be a mutableState property
    var modifiers: StatModifiers = StatModifiers()
}