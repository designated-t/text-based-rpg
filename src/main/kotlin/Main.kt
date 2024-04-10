import utils.providers.MovementProvider
import utils.Fetch
import utils.handlers.InteractionHandler
import utils.providers.ExplorationProvider

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        println("Args detected, but ignored")
    }

    println("Welcome")
    InteractionHandler.javaClass.getDeclaredMethod("fight").invoke(InteractionHandler, )
    /*while(true) {
        println("sdfs")
    }*/
}