import state.implementations.configs.AreaConfiguration
import state.implementations.configs.BattleConfiguration
import state.implementations.configs.DialogueConfiguration

object ApplicationBootstrappyConstants {
    val ACTION_CONFIGURATIONS = listOf(DialogueConfiguration(), BattleConfiguration(), AreaConfiguration())
    val BASE_STAMINA_COST = 10f
}