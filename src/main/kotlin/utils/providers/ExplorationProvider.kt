package utils.providers

import utils.handlers.EntityHandler
import utils.UserInput
import utils.characters.Entity
import utils.characters.Monster
import utils.characters.NPC
import java.lang.IndexOutOfBoundsException
import java.util.*

class ExplorationProvider(
    val movementProvider: MovementProvider
) : IProvider {

    private val entityHandler = EntityHandler
    private var currentZone = buildCurrentZone()
    private var currentZoneMonsters: Collection<Monster> = getZoneMonsters()
    private var currentZoneNPCs: Collection<NPC> = getZoneNPCs()
    private var choiceMap: Map<String, Collection<Entity>> = buildCurrentChoiceMap()

    private val userInput: UserInput = UserInput()

    private val tab: String = "\t"

    override fun announceChoices() {
        if (choiceMap.isNotEmpty()) println("You can make the following choices: ")

        choiceMap
            .keys
            .forEach {
                println("${tab}${capitalizedKey(it)}:")
                choiceMap[it]?.forEach {
                    entity -> println("${tab}${tab}${entity.name}")
                }
            }
    }

    override fun provide() {
        explore()
        announceChoices()

        provideAux()

    }

    override fun toString(): String = "Explore"

    private fun explore() {
        currentZoneMonsters = getZoneMonsters()
        currentZoneNPCs = getZoneNPCs()

        choiceMap = buildCurrentChoiceMap()
    }

    private fun provideAux() {
        try {
            val nextMove = userInput.get(choiceMap.keys)
            //TODO: Implement InteractionProvider for the next steps
            previousZone = currentZone
            currentZone = zones
                .getOrDefault(
                    nextZones[nextMove].id,
                    currentZone
                )

        } catch (e: NumberFormatException) {
            println("Invalid Input. Expecting a number.")
        } catch (e: IndexOutOfBoundsException) {
            // Verification for this exception is already made in userInput.get(),
            // but I do it here too just so compiler doesn't complain ever
            println("Invalid Input. Please input a number between 0 and ${nextZones.size - 1}")
        } finally {
            if (currentZone == previousZone)
                provideAux()
            else
                println("Moved from ${previousZone.name} to ${currentZone.name}")
        }
    }

    private fun getZoneMonsters(): Collection<Monster> = entityHandler.getMonstersByIds(currentZone.monsters)
    private fun getZoneNPCs(): Collection<NPC> = entityHandler.getNPCsByIds(currentZone.npcs)
    private fun buildCurrentZone() = movementProvider.getCurrentZone()
    private fun buildCurrentChoiceMap(): Map<String, Collection<Entity>> {
        val tempMap = mutableMapOf<String, Collection<Entity>>()
        //TODO: Implement Exploration for something? Items? Shortcuts?
        if (currentZoneMonsters.isNotEmpty()) tempMap["fight"] = currentZoneMonsters
        if (currentZoneNPCs.isNotEmpty()) tempMap["talk"] = currentZoneNPCs
        return tempMap
    }
    private fun capitalizedKey(string: String): String = string.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}