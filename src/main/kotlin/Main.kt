import utils.providers.MovementProvider
import utils.Fetch
import utils.providers.ExplorationProvider

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Args detected, but ignored")
    }

    val fetcher = Fetch
    val world = fetcher.worlds().first()
    val entities = fetcher.entities()

    val movementProvider = MovementProvider()
    val explorationProvider = ExplorationProvider(movementProvider)

    println("Welcome")

    while(true) {
        println("sdfs")
    }
}