package state.implementations.configs

import enums.GameState
import state.IAction
import state.IActionConfiguration

class DialogueConfiguration: IActionConfiguration {

    override val actions: List<IAction> = listOf()

    override fun getGameState(): GameState = GameState.DIALOGUE
}