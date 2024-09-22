package state.implementations.configs

import enums.GameState
import state.IActionConfiguration
import state.implementations.actions.Fight

class BattleConfiguration: IActionConfiguration {

    override val actions = listOf(Fight())

    override fun getGameState(): GameState = GameState.BATTLE
}