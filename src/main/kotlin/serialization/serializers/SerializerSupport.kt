package serialization.serializers

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

object SerializerSupport {

    fun getProp(tree: JsonObject, propName: String) =
        tree[propName]?.jsonPrimitive?.content
            ?: throw SerializationException("JSON property 'world' is required.")
}