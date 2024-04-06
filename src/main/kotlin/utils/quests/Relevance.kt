package utils.quests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Relevance {
    @SerialName("main") MAIN,
    @SerialName("side") SIDE,
    @SerialName("optional") OPTIONAL
}
