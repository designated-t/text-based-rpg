package utils.handlers

import utils.Fetch
import utils.characters.Monster
import utils.characters.NPC

object EntityHandler {

    val npcs: Collection<NPC> = Fetch.npcs()
    val monsters: Collection<Monster> = Fetch.monsters()

    fun getMonstersByIds(ids: Collection<String>): Collection<Monster> = monsters.filter { it.id in ids }
    fun getNPCsByIds(ids: Collection<String>): Collection<NPC> = npcs.filter { it.id in ids }
    fun getMonsterById(id: String): Monster = monsters.first { it.id == id }
    fun getNPCById(id: String): NPC = npcs.first { it.id == id }
}
