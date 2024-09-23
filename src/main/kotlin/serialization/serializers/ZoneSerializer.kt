package serialization.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.serializer
import serialization.serializable.map.MapHandler
import serialization.serializable.map.Zone
import serialization.serializers.SerializerSupport.getProp

object ZoneSerializer : KSerializer<Zone> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Zone")

    override fun deserialize(decoder: Decoder): Zone {
        val input = decoder as? JsonDecoder ?: throw SerializationException("Expected JsonDecoder")
        val tree = input.decodeJsonElement().jsonObject

        val name: String = getProp(tree, "name")
        val id: String = getProp(tree, "id")
        val worldId: String = getProp(tree, "world")

        val world = MapHandler.provideWorldById(worldId)

        return Zone(id, name, world)
    }

    override fun serialize(encoder: Encoder, value: Zone) {
        encoder.encodeSerializableValue(serializer(), value)
    }
}