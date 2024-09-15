package state

interface IAction {
    fun getName() = this::class.simpleName!!
    fun perform(context: GameContext): List<String>
}