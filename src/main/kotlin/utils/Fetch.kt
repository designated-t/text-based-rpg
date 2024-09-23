package utils

import androidx.compose.ui.input.key.Key.Companion.T
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.reflect.KClass
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import serialization.serializable.Identifiable
import serialization.serializable.item.BasicItem

object Fetch {
    private const val RESOURCES_PATH = ".\\src\\main\\resources"
    private const val JSON_PATH = "$RESOURCES_PATH\\json"

    fun getPath(classForPath: KClass<*>) = "$JSON_PATH\\${classForPath.simpleName!!.lowercase()}"

    inline fun <reified T : Identifiable> it(): Map<String, T> = genericJsonFetchFromFile<T>(getPath(T::class)).associateBy { it.id }
    fun them() = basicItemFetch<BasicItemWrapper>(getPath(BasicItem::class))


    inline fun <reified T> genericJsonFetchFromFile(path: String): Collection<T> {
        return Files.walk(
            Paths.get(path)
        ).use { paths ->
            paths
                .filter(Files::isRegularFile)
                .map { File(it.toString()).bufferedReader().readText() }
                .toList()
        }.map { Json.decodeFromString<T>(it) }
    }

    fun basicItemFetch(path: String): Collection<T> {
        return Files.(
                Paths.get(path)
                ).use { paths ->
            paths
                .filter(Files::isRegularFile)
                .map { File(it.toString()).bufferedReader().readText() }
                .toList()
        }.map { Json.decodeFromString<T>(it) }
    }

    //sleepy so ima do this for now
    @Serializable
    data class BasicItemWrapper(
        val items: Collection<BasicItem>
    )
}