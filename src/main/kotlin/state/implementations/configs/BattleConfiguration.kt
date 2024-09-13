package state.implementations.configs

import GameState
import state.AbstractActionable
import state.ActionConfiguration

class BattleConfiguration: ActionConfiguration {

    override fun getGameState(): GameState = GameState.BATTLE

    override fun getActions(): List<AbstractActionable> {
        TODO("Not yet implemented")
    }
}