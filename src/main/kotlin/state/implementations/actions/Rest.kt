package state.implementations.actions

import state.GameContext
import state.IAction

class Rest: IAction {
    override fun perform(context: GameContext) {
        context.player.stamina.value += 20 // TODO: unhardcode this

        if (context.player.stamina.value > 100)
            context.player.stamina.value = 100
    }
}
