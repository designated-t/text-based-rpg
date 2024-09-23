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
import serialization.serializable.map.Area
import serialization.serializable.map.MapHandler
import serialization.serializers.SerializerSupport.getProp

object AreaSerializer : KSerializer<Area> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Area")

    override fun deserialize(decoder: Decoder): Area {
        val input = decoder as? JsonDecoder ?: throw SerializationException("Expected JsonDecoder")
        val tree = input.decodeJsonElement().jsonObject

        val name: String = getProp(tree, "name")
        val id: String = getProp(tree, "id")
        val zoneId: String = getProp(tree, "zone")

        val zone = MapHandler.provideZoneById(zoneId)

        return Area(id, name, zone)
    }

    override fun serialize(encoder: Encoder, value: Area) {
        encoder.encodeSerializableValue(serializer(), value)
    }
}