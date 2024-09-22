package state.implementations.actions

import ApplicationBootstrappyConstants.BASE_STAMINA_COST
import History
import Player
import enums.GameState
import enums.StatType
import serialization.serializable.item.ItemHandler
import state.GameContext
import state.IAction
import stats.stat.StatHandler

class Explore: IAction {
    override suspend fun perform(context: GameContext) {

        // TODO: Wrap in "canExplore()" if statement
        val costMessage = consumeStamina(context.player)

        History.printToHistory(costMessage)

        // Make a UI map. Make it so Exploring makes adjacent areas available
        // Make it so there is a chance to find a battle
        val finding = generateFinding(context)

        History.printToHistory(finding.message)
        context.gameState = finding.nextGameState
    }

    private fun generateFinding(context: GameContext): Finding {

        val item = ItemHandler.generateItem()

        return Finding(
            message = "Found an item: ${item.name}",
            nextGameState = GameState.AREA
        )
    }

    private fun consumeStamina(player: Player): String {
        val multipliedStaminaCost = StatHandler.multiply(StatType.STAMINA_COST, BASE_STAMINA_COST, player.modifiers)
        var costMessage = ""

        if (player.stamina.value >= multipliedStaminaCost) {
            player.stamina.value -= multipliedStaminaCost
            costMessage = "You've explored and spent $multipliedStaminaCost Stamina"
        } else
            costMessage = "You cannot spend $multipliedStaminaCost to explore!"

        return costMessage
    }
}

data class Finding(
    val message: String,
    val nextGameState: GameState
)