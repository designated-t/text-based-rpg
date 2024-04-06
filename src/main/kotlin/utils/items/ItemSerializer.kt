package utils.items

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer

object ItemSerializer : KSerializer<Item> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Item")

    override fun serialize(encoder: Encoder, value: Item) {
        encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): Item {
        val input = decoder as? JsonDecoder ?: throw SerializationException("Expected JsonDecoder")
        val tree = input.decodeJsonElement().jsonObject

        return when (val itemType = tree["type"]?.jsonPrimitive?.content) {
            "weapon" -> input.json.decodeFromJsonElement<Weapon>(tree)
            "accessory" -> input.json.decodeFromJsonElement<Accessory>(tree)
            "chest_armour",
            "leg_armour",
            "foot_armour",
            "head_armour" -> input.json.decodeFromJsonElement<Armour>(tree)
            else -> throw SerializationException("Unknown type: $itemType")
        }
    }
}