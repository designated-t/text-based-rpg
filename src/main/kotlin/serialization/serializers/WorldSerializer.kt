package serialization.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.serializer
import serialization.serializable.map.MapHandler
import serialization.serializable.map.World

object WorldSerializer : KSerializer<World> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Zone")

    override fun deserialize(decoder: Decoder): World {
        val input = decoder as? JsonDecoder ?: throw SerializationException("Expected JsonDecoder")
        val tree = input.decodeJsonElement().jsonObject

        val worldId = input.json.decodeFromJsonElement<String>(tree)

        return MapHandler.provideWorldById(worldId)
    }

    override fun serialize(encoder: Encoder, value: World) {
        encoder.encodeSerializableValue(serializer(), value)
    }
}