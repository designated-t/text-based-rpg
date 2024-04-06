package utils

class UserInput {
    fun get(amountOfChoices: Int): Int {
        var userInput = -1
        try {
            userInput = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Invalid Input. Expecting a number.")
        } finally {
            if (userInput == -1)
                userInput = get(amountOfChoices)
            else if (userInput >= amountOfChoices) {
                println("Invalid Input. Please input a number between 0 and ${amountOfChoices - 1}")
                userInput = get(amountOfChoices)
            }

        }

        return userInput
    }

    fun get(listOfChoices: Collection<String>) {

    }
}