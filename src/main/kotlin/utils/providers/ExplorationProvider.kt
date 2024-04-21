package utils.providers

import utils.handlers.EntityHandler
import utils.UserInput
import utils.characters.Entity
import utils.characters.Monster
import utils.characters.NPC
import utils.handlers.InteractionHandler
import utils.maps.Zone
import java.lang.IndexOutOfBoundsException
import java.util.*

class ExplorationProvider(
    private val movementProvider: MovementProvider
) : IProvider {

    private var currentZone: Zone = movementProvider.currentZone
    private var currentZoneMonsters: Collection<Monster> = getZoneMonsters()
    private var currentZoneNPCs: Collection<NPC> = getZoneNPCs()
    private var choiceMap: Map<String, Collection<Entity>> = buildCurrentChoiceMap()

    private val tab: String = "\t"

    override fun announceChoices() {
        println("You can make the following choices: ")

        choiceMap
            .keys
            .forEachIndexed { index, key ->
                println("$index -> ${capitalizedKey(key)}:")
                choiceMap[key]
                    ?.forEach{ entity ->
                        println("$tab${entity.name}")
                    }
            }
    }

    override fun provide() {
        if (thereAreChoices()) {
            announceChoices()

            provideAux()
        }
    }

    override fun canProvide(): Boolean = thereAreChoices()

    override fun update() {
        currentZone = movementProvider.currentZone

        currentZoneMonsters = getZoneMonsters()
        currentZoneNPCs = getZoneNPCs()

        choiceMap = buildCurrentChoiceMap()
    }

    override fun toString(): String = "Explore"

    private fun provideAux() {
        val nextMoveIndex = UserInput.get<Int>(choiceMap.keys)
        val nextMoveKey = choiceMap.keys.elementAt(nextMoveIndex)

        choiceMap[nextMoveKey]
            ?.forEachIndexed { index, entity ->
                println("$index -> ${entity.name}")
            }

        val entityChoiceIndex = UserInput.get<Int>(choiceMap[nextMoveKey]!!.map { it.id })
        val entityChoiceId = choiceMap[nextMoveKey]!!.elementAt(entityChoiceIndex).id

        InteractionHandler.javaClass
            .getDeclaredMethod(nextMoveKey, String::class.java)
            .invoke(InteractionHandler, entityChoiceId)
    }

    private fun getZoneMonsters(): Collection<Monster> = EntityHandler.getMonstersByIds(currentZone.monsters)
    private fun getZoneNPCs(): Collection<NPC> = EntityHandler.getNPCsByIds(currentZone.npcs)
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

    private fun thereAreChoices() = choiceMap.isNotEmpty()
}