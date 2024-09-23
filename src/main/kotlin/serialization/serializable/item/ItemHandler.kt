package serialization.serializable.item

import utils.Fetch

object ItemHandler {

    private val items: Map<String, BasicItem> = populate().flatMap { it.items }.associateBy { it.id }

    // TODO: Do like a minecraft system where items have dynamic metadata that modifies the item
    fun generateItem() = items.values.random()

    private fun populate() = Fetch.them()
}