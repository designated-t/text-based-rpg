package serialization.serializable.item

import serialization.serializable.Identifiable

interface BaseItem : Identifiable {
    val name: String
    val type: String

}