import androidx.compose.runtime.mutableStateListOf
import java.util.UUID

object History {
    val commandHistory = mutableStateListOf<Message>()

    fun printToHistory(input: String) {
        //popHistoryIfFull()

        commandHistory.add(Message(input))
    }

    private fun popHistoryIfFull() {
        if (commandHistory.size > 20) commandHistory.drop(1)
    }
}

data class Message(
    val content: String,
    val id: UUID = UUID.randomUUID()
)