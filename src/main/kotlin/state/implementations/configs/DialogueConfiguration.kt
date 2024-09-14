package state.implementations.configs

import GameState
import state.IAction
import state.IActionConfiguration

class DialogueConfiguration: IActionConfiguration {

    override fun getGameState(): GameState = GameState.DIALOGUE

    override fun getActions(): List<IAction> = listOf()
}