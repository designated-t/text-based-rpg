package state.implementations.configs

import GameState
import state.IAction
import state.IActionConfiguration
import state.implementations.actions.Fight

class BattleConfiguration: IActionConfiguration {

    override fun getGameState(): GameState = GameState.BATTLE

    override fun getActions(): List<IAction> = listOf(Fight(), )
}