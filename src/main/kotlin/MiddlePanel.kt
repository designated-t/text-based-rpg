import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import state.GameContext
import state.implementations.configs.ActionConfigurationProvider

@Composable
fun RowScope.MiddlePanel(gameContext: GameContext) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .weight(3f)
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
    ) {
        TextHistorySubPanel()

        InputSubPanel(gameContext)
    }
}

@Composable
fun ColumnScope.InputSubPanel(gameContext: GameContext) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(.05f)
            .background(color = Color.DarkGray)
    ) {
        for (action in ActionConfigurationProvider.provide(gameContext.gameState).actions) {
            Button(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                onClick = {
                    coroutineScope.launch {
                        action.perform(gameContext)
                    }
                },
            ) {
                Text(
                    text = action.getName(),
                    fontSize = NORMAL_FONT_SIZE,
                )
            }
        }
    }
}

@Composable
fun ColumnScope.TextHistorySubPanel() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(.95f)
            .background(color = Color.LightGray)
    ) {
        var columnWidth by remember { mutableStateOf(0f) }

        /*Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {*/
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned { layoutCoordinates ->
                    // Capture the width of the column after it's laid out
                    columnWidth = layoutCoordinates.size.width.toFloat()
                },
            verticalArrangement = Arrangement.Bottom,
        ) {
            items(
                items = History.commandHistory,
                key = { it.id }
            ) { message ->
                MessageText(message.content, columnWidth)
            }
        }
        //}

    }
}

@Composable
fun MessageText(content: String, columnWidth: Float) {
    Text(
        text = content,
        color = Color.Black,
        fontSize = NORMAL_FONT_SIZE,
        softWrap = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 2.dp)
    )
    CustomLine(
        startOffset = Offset(0f, 0f),
        endOffset = Offset(columnWidth, 0f)
    )
}


@Composable
fun CustomLine(
    color: Color = Color.Gray,
    thickness: Dp = .4f.dp,
    startOffset: Offset = Offset(0f, 0f),
    endOffset: Offset = Offset(100f, 0f)
) {
    Canvas(
        modifier = Modifier.size(100.dp, thickness)
    ) {
        drawLine(
            color = color,
            start = startOffset,
            end = endOffset,
            strokeWidth = thickness.toPx()
        )
    }
}
