package state

import enums.GameState

interface IActionConfiguration {
    val actions: List<IAction>
    fun getGameState(): GameState
}