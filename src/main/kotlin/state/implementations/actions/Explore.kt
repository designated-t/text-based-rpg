package state.implementations.actions

import ApplicationBootstrappyConstants.BASE_STAMINA_COST
import Player
import StatHandler
import enums.StatType
import state.GameContext
import state.IAction

class Explore: IAction {
    override fun perform(context: GameContext) {
        consumeStamina(context.player)
    }

    private fun consumeStamina(player: Player) {
        val multipliedStaminaCost = StatHandler.multiply(StatType.STAMINA, BASE_STAMINA_COST, player.modifiers)

        if (player.stamina.value < BASE_STAMINA_COST)
            player.stamina.value = 0f
        else
            player.stamina.value -= multipliedStaminaCost
    }
}