package state.implementations.configs

import enums.GameState
import state.IActionConfiguration
import state.implementations.actions.Explore
import state.implementations.actions.Rest

class AreaConfiguration: IActionConfiguration {

    override val actions = listOf(Explore(), Rest())

    override fun getGameState(): GameState = GameState.AREA

}