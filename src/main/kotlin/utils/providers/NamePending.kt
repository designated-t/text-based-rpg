package utils.providers

import utils.UserInput

class NamePending(
    private val providers: List<IProvider>
) {

    fun makeChoice() {
        providers
            .forEachIndexed { index, provider ->
                if (provider.canProvide())
                    println("$index -> $provider")
            }

        val input = UserInput.get<Int>(providers.map { toString() })
        providers[input].provide()
    }

    fun updateProviders() = providers.forEach { it.update() }
}