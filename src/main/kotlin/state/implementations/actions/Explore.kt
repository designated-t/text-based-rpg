package state.implementations.actions

import state.GameContext
import state.IAction

class Explore: IAction {
    override fun perform(context: GameContext) {
        context.player.stamina.value -= 20 // TODO: unhard code this

        if (context.player.stamina.value < 0)
            context.player.stamina.value = 0
    }
}