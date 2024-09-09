import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
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
        modifier = Modifier.fillMaxHeight().weight(1f),
        verticalArrangement = Arrangement.Center
    ) {
        BasicText("Placeholder for Program Statistics")
        // Add more details or items as needed
    }
}

fun main() = application {
/*
    // Get the screen configuration
    val graphicsConfig = GraphicsEnvironment.getLocalGraphicsEnvironment().defaultScreenDevice.defaultConfiguration
    val screenSize = graphicsConfig.bounds
    val taskbarInsets = Toolkit.getDefaultToolkit().getScreenInsets(graphicsConfig)

    // Calculate available screen dimensions excluding taskbar/dock
    val availableWidth = screenSize.width - taskbarInsets.left - taskbarInsets.right
    val availableHeight = screenSize.height - taskbarInsets.top - taskbarInsets.bottom

    val maxedScreenSize = DpSize(height = availableHeight.dp, width = availableWidth.dp)
*/

    val windowState = remember {
        WindowState(
            //position = WindowPosition(0.dp, 0.dp)
            placement = WindowPlacement.Maximized
        )
    }

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Tale of Timid",
    ) {
        window.minimumSize = Dimension(MIN_WINDOW_WIDTH, MIN_WINDOW_HEIGHT)

        //var windowOffset by remember { mutableStateOf(Offset.Zero) }

        Column(modifier = Modifier.fillMaxSize()) {
            /*TopBar(
                windowOffsetIncrement = { dragAmount ->
                    windowOffset += dragAmount
                    windowOffset
                },
                exit = { exitApplication() },
                windowState = windowState,
                maxedScreenSize = maxedScreenSize
            )*/
            App()
        }
    }
}

@Composable
fun TopBar(
    maxedScreenSize: DpSize,
    windowState: WindowState,
    windowOffsetIncrement: (Offset) -> Offset,
    exit: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    // Update the window position when dragging
                    change.consume() // Consume the gesture
                    val windowOffset = windowOffsetIncrement(dragAmount)

                    // Move the window by setting the new position
                    windowState.position = WindowPosition(
                        (windowState.position.x.value + windowOffset.x).dp,
                        (windowState.position.y.value + windowOffset.y).dp
                    )
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tale of Timid",
            modifier = Modifier
                .padding(12.dp),
            color = Color.White
        )

        Row(
            modifier = Modifier
                .width(80.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Resize button ("▢")
            Text(
                text = "▢",
                modifier = Modifier
                    .clickable {
                        windowState.size = maxedScreenSize
                        windowState.position = WindowPosition(0.dp, 0.dp)
                    }
                    .padding(12.dp),
                color = Color.White
            )

            // Close button ("X")
            Text(
                text = "X",
                modifier = Modifier
                    .clickable { exit() }
                    .padding(12.dp),
                color = Color.White
            )
        }
    }
}

fun verifyMinimumWindowSize(windowState: WindowState) {
    if (windowState.size.height < MIN_WINDOW_HEIGHT.dp)
        windowState.size = DpSize(height = MIN_WINDOW_HEIGHT.dp, width = windowState.size.width)
    if (windowState.size.width < MIN_WINDOW_WIDTH.dp)
        windowState.size = DpSize(height = windowState.size.height, width = MIN_WINDOW_WIDTH.dp)
}