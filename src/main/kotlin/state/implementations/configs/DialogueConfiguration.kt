package state.implementations.configs

import GameState
import state.AbstractActionable
import state.ActionConfiguration

class DialogueConfiguration: ActionConfiguration {

    override fun getGameState(): GameState = GameState.DIALOGUE

    override fun getActions(): List<AbstractActionable> {
        TODO("Not yet implemented")
    }
}