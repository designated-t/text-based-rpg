package utils

class UserInput {
    inline fun <reified T> get(listOfChoices: Collection<String>): T {
        val userInput: T = when(T::class) {
            Int::class -> getIntUserInput(listOfChoices)
            String::class -> getStringUserInput(listOfChoices)
            else -> readln()
        } as T

        return userInput
    }

    fun getIntUserInput(listOfChoices: Collection<String>) : Int {
        var userInput = getIntInputAux()

        if (userInput !in listOfChoices.indices) {
            println("Invalid Input. Should be between 0 and ${listOfChoices.size}")
            userInput = getIntUserInput(listOfChoices)
        }

        return userInput
    }

    fun getStringUserInput(listOfChoices: Collection<String>) : String {
        var userInput = readln()

        if (userInput !in listOfChoices) {
            userInput = getStringUserInput(listOfChoices)
        }

        return userInput
    }

    private fun getIntInputAux(): Int {
        val userInput: Int = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            println("Invalid Input. Should be a number.")
            getIntInputAux()
        }
        return userInput
    }
}