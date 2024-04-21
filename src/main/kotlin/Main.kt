import utils.UserInput
import utils.providers.MovementProvider
import utils.providers.ExplorationProvider
import utils.providers.NamePending
import java.util.*
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Args detected, but ignored")
    }

    val movement = MovementProvider()
    val exploration = ExplorationProvider(movement)
    val looper = NamePending(listOf(movement, exploration))

    print("\rWelcome")
    while(true) {
        looper.updateProviders()
        println("Currently in: ${movement.currentZone.name}")
        looper.makeChoice()
    }
}

fun progress(current: Int, total: Int) {
    val pp = ((current / total) * 10000) / 100
    print("\rProgress: $current/$total ($pp%) ")
}