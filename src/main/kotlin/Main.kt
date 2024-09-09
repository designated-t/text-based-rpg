
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import java.awt.Dimension

const val MIN_WINDOW_HEIGHT = 600
const val MIN_WINDOW_WIDTH = 800
fun textUnit(f: Float) = TextUnit(f, TextUnitType.Em)
val TITLE_FONT_SIZE = textUnit(2f)
val SUBTITLE_FONT_SIZE = textUnit(1.5f)
val LARGE_FONT_SIZE = textUnit(1.2f)
val NORMAL_FONT_SIZE = textUnit(1f)


@Composable
fun App() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Row to display text, image, and stats in a horizontal layout
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LeftSidePanel()

            MiddlePanel()

            RightSidePanel()
        }
    }
}


@Composable
fun RowScope.LeftSidePanel() {
    // Section for text on the left
    Column(
        modifier = Modifier.fillMaxHeight().weight(2f),
        verticalArrangement = Arrangement.Center
    ) {
        BasicText("Placeholder for Program Statistics")
        // Add more details or items as needed
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(
            placement = WindowPlacement.Maximized
        ),
        title = "Tale of Timid",
    ) {
        window.minimumSize = Dimension(MIN_WINDOW_WIDTH, MIN_WINDOW_HEIGHT)

        Column(modifier = Modifier.fillMaxSize()) {
            App()
        }
    }
}