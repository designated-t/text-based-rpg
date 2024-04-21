package utils.providers

interface IProvider {
    fun announceChoices()
    fun provide()
    fun canProvide(): Boolean
    fun update()
    override fun toString(): String
}