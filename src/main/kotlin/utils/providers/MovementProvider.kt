package utils.providers

import utils.Fetch
import utils.UserInput
import utils.maps.World
import utils.maps.Zone

class MovementProvider : IProvider {
    private val worlds: Collection<World> = Fetch.worlds()
    private val world: World = worlds.first()

    private val zones: Map<String, Zone> = buildZones()
    var currentZone = world.zones.first()
    private var previousZone = currentZone
    private var nextZones = assignNextZones()

    override fun provide() {
        announceChoices()
        // Aux method to not repeat announceChoices() method execution
        provideAux()
    }

    override fun update() {
        nextZones = assignNextZones()
    }


    override fun announceChoices() {
        if (thereAreZonesToMoveTo()) {
            println("You can move to the following zones: ")

            nextZones
                .forEachIndexed { index, zone ->
                    println("$index -> ${zone.name}")
                }
        }
    }

    override fun canProvide(): Boolean = thereAreZonesToMoveTo()

    private fun thereAreZonesToMoveTo() = nextZones.isNotEmpty()

    private fun assignNextZones(): List<Zone> {
        return currentZone.connector
            .getValidConnectorsAsString()
            .mapNotNull { zones[it] }
            .toList()
    }

    private fun provideAux() {
        val nextMove = UserInput.get<Int>(
                List(nextZones.size) { it.toString() }
        )

        previousZone = currentZone
        currentZone = zones
            .getOrDefault(
                nextZones[nextMove].id,
                currentZone
            )

        if (currentZone == previousZone)
            provideAux()
        else
            println("Moved from ${previousZone.name} to ${currentZone.name}")

    }

    private fun buildZones(): Map<String, Zone> = world.zones.associateBy { it.id }
    override fun toString(): String = "Move"
}

