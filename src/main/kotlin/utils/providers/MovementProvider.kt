package utils.providers

import utils.Fetch
import utils.UserInput
import utils.maps.World
import utils.maps.Zone
import java.lang.IndexOutOfBoundsException

class MovementProvider : IProvider {
    private val worlds: Collection<World> = Fetch.worlds()
    private val world: World = worlds.first()

    private val zones: Map<String, Zone> = buildZones()
    private var currentZone = world.zones.first()
    private var previousZone = currentZone
    private var nextZones = assignNextZones()

    private val userInput: UserInput = UserInput()
    override fun provide() {
        announceChoices()
        // Aux method to not repeat announceChoices() method execution
        provideAux()

        nextZones = assignNextZones()
    }

    override fun toString(): String {
        return "Movement"
    }

    override fun announceChoices() {
        println("You can move to the following zones: ")

        nextZones
            .forEachIndexed { index, zone ->
                println("$index -> ${zone.name}")
            }
    }

    fun canMove() = nextZones.isNotEmpty()

    internal fun getCurrentZone() = currentZone

    private fun assignNextZones(): List<Zone> {
        return currentZone.connector
            .getValidConnectorsAsString()
            .mapNotNull { zones[it] }
            .toList()
    }

    private fun provideAux() {
        try {
            val nextMove = userInput.get(nextZones.size)

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

    private fun buildZones(): Map<String, Zone> = world.zones.associateBy { it.id }
}

