package serialization.serializable.item

object ItemHandler {

    // TODO: Do like a minecraft system where items have dynamic metadata that modifies the item
    fun generateItem() =
        BasicItem(
            name = "Stick",
            type = "Misc",
            id = "item_stick"
        )
}