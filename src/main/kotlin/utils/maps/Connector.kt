package utils.maps

import kotlinx.serialization.Serializable

@Serializable
data class Connector(
    val front: String = "",
    val behind: String = "",
    val left: String = "",
    val right: String = "",
    val others: Collection<String> = emptyList()
) {
    fun getValidConnectorsAsString(): Collection<String> {
        val returnList = mutableListOf<String>()
        if (front.isNotEmpty()) returnList.add(front)
        if (behind.isNotEmpty()) returnList.add(behind)
        if (left.isNotEmpty()) returnList.add(left)
        if (right.isNotEmpty()) returnList.add(right)
        if (others.isNotEmpty()) returnList.addAll(others)
        return returnList
    }
}
