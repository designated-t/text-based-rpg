package state.implementations.configs

import ApplicationBootstrappyConstants
import GameState
import java.util.EnumMap
import state.ActionConfiguration

class ActionConfigurationProvider {
    private val actionByGameState: EnumMap<GameState, ActionConfiguration> = EnumMap(GameState::class.java)
    private val actionConfigs = ApplicationBootstrappyConstants.ACTION_CONFIGURATIONS

    init {
        actionConfigs.forEach {
            actionByGameState[it.getGameState()] = it
        }
    }

    fun provide(gameState: GameState) = actionByGameState[gameState]
}