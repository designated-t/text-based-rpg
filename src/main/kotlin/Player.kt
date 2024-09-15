import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

object Player {
    val inventory = mutableStateListOf<String>()
    var health = 100f
    var stamina = mutableStateOf(100f)
    var modifiers: Modifiers = Modifiers()
}