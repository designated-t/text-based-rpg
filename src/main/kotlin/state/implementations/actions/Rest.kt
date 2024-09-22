package state.implementations.actions

import History
import Player
import enums.StatType
import state.GameContext
import state.IAction
import stats.stat.StatHandler

const val BASE_STAMINA_REGENERATION = 60f

class Rest : IAction {

    override suspend fun perform(context: GameContext) {
        val regenerationMessage = replenishStamina(context.player)

        History.printToHistory(regenerationMessage)
    }

    // TODO: Resting should also regenerate health. probably done when Battle is implemented
    private fun replenishStamina(player: Player): String {
        val multipliedStaminaRegen =
            StatHandler.multiply(StatType.STAMINA_REGEN, BASE_STAMINA_REGENERATION, player.modifiers)

        val maxStamRegen = player.stats.maxStamina.value - player.stamina.value

        val finalRegen =
            if (multipliedStaminaRegen > maxStamRegen)
                maxStamRegen
            else
                multipliedStaminaRegen

        player.stamina.value += finalRegen

        return generateTextFromRegen(finalRegen)
    }

    private fun generateTextFromRegen(finalRegen: Float): String =
        if (finalRegen == 0f)
            "Resting won't regenerate your stamina further!"
        else
            "You've rested to regenerate $finalRegen Stamina"

}
