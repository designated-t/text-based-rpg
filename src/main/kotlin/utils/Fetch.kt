package utils
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.reflect.KClass
import kotlinx.serialization.json.Json
import serialization.serializable.Identifiable

object Fetch {
    private const val RESOURCES_PATH = ".\\src\\main\\resources"
    private const val JSON_PATH = "$RESOURCES_PATH\\json"

    fun getPath(classForPath: KClass<*>) = "$JSON_PATH\\${classForPath.simpleName!!.lowercase()}"

    inline fun <reified T : Identifiable> it(): Map<String, T> = genericJsonFetchFromFile<T>(getPath(T::class)).associateBy { it.id }

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
}