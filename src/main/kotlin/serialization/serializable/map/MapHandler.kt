package serialization.serializable.map

import serialization.serializable.Identifiable
import utils.Fetch

object MapHandler {
    private val worlds: Map<String, World> = populate()
    private val zones: Map<String, Zone> = populate()
    private val areas: Map<String, Area> = populate()

    private inline fun <reified T: Identifiable> populate() = Fetch.it<T>()

    fun provideAreaById(id: String) = areas[id]!!
    fun provideZoneById(id: String) = zones[id]!!
    fun provideWorldById(id: String) = worlds[id]!!
}