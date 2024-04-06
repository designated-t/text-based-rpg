package utils

import kotlinx.serialization.json.Json
import utils.characters.Entity
import utils.characters.Monster
import utils.characters.NPC
import utils.maps.World
import utils.quests.Scenario
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

object Fetch {
    private const val resourcesPath = ".\\src\\main\\resources"

    private const val scenariosPath = "$resourcesPath\\scenarios"
    private const val mapsPath = "$resourcesPath\\maps"
    private const val monstersPath = "$resourcesPath\\entities\\monsters"
    private const val npcPath = "$resourcesPath\\entities\\npc"

    fun scenarios(): Collection<Scenario> = genericJsonFetchFromFile<Scenario>(scenariosPath)

    fun worlds(): Collection<World> = genericJsonFetchFromFile<World>(mapsPath)

    fun monsters(): Collection<Monster> = genericJsonFetchFromFile<Monster>(monstersPath)

    fun npcs(): Collection<NPC> = genericJsonFetchFromFile<NPC>(npcPath)

    private inline fun <reified T> genericJsonFetchFromFile(path: String): Collection<T> {
        return Files.walk(
            Paths.get(path)
        ).use { paths ->
            paths
                .filter(Files::isRegularFile)
                .map { File(it.toString()).bufferedReader().readText() }
                .toList()
        }.map { Json.decodeFromString<T>(it) }
    }


}