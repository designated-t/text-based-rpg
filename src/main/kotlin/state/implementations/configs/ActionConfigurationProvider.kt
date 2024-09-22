package state.implementations.configs

import ApplicationBootstrappyConstants
import enums.GameState
import java.util.EnumMap
import state.IActionConfiguration

object ActionConfigurationProvider {
    private val actionConfigByGameState: EnumMap<GameState, IActionConfiguration> = EnumMap(GameState::class.java)
    private val actionConfigs = ApplicationBootstrappyConstants.ACTION_CONFIGURATIONS

    init {
        actionConfigs.forEach {
            actionConfigByGameState[it.getGameState()] = it
        }
    }

    fun provide(gameState: GameState) = actionConfigByGameState[gameState]!!
}