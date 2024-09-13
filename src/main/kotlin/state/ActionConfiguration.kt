package state

import GameState

interface ActionConfiguration {
    fun getGameState(): GameState
    fun getActions(): List<AbstractActionable>
}