package state

import enums.GameState

interface IActionConfiguration {
    fun getGameState(): GameState
    fun getActions(): List<IAction>
}