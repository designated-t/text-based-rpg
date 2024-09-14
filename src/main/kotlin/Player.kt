import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

object Player {
    val inventory = mutableStateListOf<String>()
    var health = 100
    var stamina = mutableStateOf(100)
}