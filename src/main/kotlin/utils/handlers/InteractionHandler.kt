package utils.handlers

import utils.UserInput
import utils.characters.NPC
import utils.quests.QuestTrigger

/** Handles interactions with Entities. Each method should have the name of a choice in ExplorationProvider choiceMap.
 */
object InteractionHandler {

    private val interactions: Collection<String> = listOf("Chit chat", "Quests", "Leave")
    private val goodbyeInput: Int = interactions.indices.last


    fun fight() {
        println("fight")
    }

    fun talk(entityId: String) {
        val npc = EntityHandler.getNPCById(entityId)
        println("Choose one of the possible interactions:")
        do {
            interactions.forEachIndexed { index, interaction ->
                println("$index -> $interaction")
            }
            val userInput = UserInput.getIntUserInput(interactions)

            when(userInput) {
                0 -> println(npc.dialogues.elementAt(interactions.indices.random()))
                1 -> DialogueHelper.handleQuestDialogue(npc)
                2 -> break
            }

        } while (userInput != goodbyeInput)
    }

    object DialogueHelper {

        private val replies = listOf("Yes", "No")
        private const val pressEnter = "Press enter to continue"
        private const val backslash = "\b"

        private fun acceptQuest(quest: QuestTrigger) {
            quest.dialogues.forEach {
                println("Eugenia: $it")
                print(pressEnter)
                UserInput.getAnyUserInput()
                clearLine()
            }

            quest.questAccepted = true
            println("Quest Accepted: ${quest.id}")
            //TODO add scenario started, chain quest warning and such
        }

        private fun clearLine() {
            print("\u001b[1A\u001b[2K")
        }

        fun handleQuestDialogue(npc: NPC) {
            if (npc.relatedQuests.isNotEmpty()) {
                try {
                    val relatedQuest = npc.relatedQuests.first { !it.questAccepted }

                    println(relatedQuest.trigger)
                    replies.forEachIndexed { index, reply ->
                        println("$index -> $reply")
                    }

                    when (UserInput.getIntUserInput(replies)) {
                        0 -> acceptQuest(relatedQuest)
                        1 -> println(relatedQuest.denialOfTrigger)
                    }
                } catch (e: NoSuchElementException) {
                    println("You've accepted all my quests!")
                }
            } else {
                println("I don't have any quests for you! Thank you for stopping by.")
            }

        }
    }

}