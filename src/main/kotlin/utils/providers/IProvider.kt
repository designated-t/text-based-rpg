package utils.providers

interface IProvider {
    fun announceChoices()
    fun provide()
    override fun toString(): String
}