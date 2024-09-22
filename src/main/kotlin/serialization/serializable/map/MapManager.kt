package serialization.serializable.map

import utils.Fetch
import serialization.serializable.Identifiable

object MapManager {
    private val worlds: Map<String, World>
    private val zones: Map<String, Zone>
    private val areas: Map<String, Area>

    private inline fun <reified T: Identifiable> populate() = Fetch.it<T>()

    init {
        worlds = populate<World>()
        zones = populate<Zone>()
        areas = populate<Area>()
    }

    fun provideAreaById(id: String) = areas[id]!!
    fun provideZoneById(id: String) = zones[id]!!
    fun provideWorldById(id: String) = worlds[id]!!
}