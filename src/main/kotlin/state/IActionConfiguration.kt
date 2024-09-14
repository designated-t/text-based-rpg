package state

import GameState

interface IActionConfiguration {
    fun getGameState(): GameState
    fun getActions(): List<IAction>
}