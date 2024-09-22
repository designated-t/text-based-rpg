package state

interface IAction {
    fun getName() = this::class.simpleName!!
    suspend fun perform(context: GameContext)
}