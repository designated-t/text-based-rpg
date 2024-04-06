package utils.providers

import utils.UserInput

class NamePending(
    private val movementProvider: MovementProvider,
    private val explorationProvider: ExplorationProvider
) {
    private val userInput: UserInput = UserInput()

    private var providers: List<IProvider> = buildProviders()

    fun makeChoice() {
        providers
            .forEachIndexed { index, provider ->
                println("$index -> $provider")
            }

        val input = userInput.get(providers.size)
        providers[input].provide()
        makeChoice()
    }

    private fun buildProviders() = listOf(explorationProvider, movementProvider)
}