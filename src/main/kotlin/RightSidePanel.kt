
import ImageProvider.LoadImageFromFile
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import state.GameContext

const val INVENTORY_COLUMNS = 9
const val INVENTORY_BUTTON_SIZE = 150

@Composable
fun RowScope.RightSidePanel(gameContext: GameContext) {
    // Section for more information on the right
    Column(
        modifier = Modifier.fillMaxHeight().weight(2f), verticalArrangement = Arrangement.Top
    ) {
        // Placeholder image box
        LoadImageFromFile("swag.png")
        Inventory()
    }
}

@Composable
fun ColumnScope.Inventory() {
    var gridSize by remember { mutableStateOf(IntSize.Zero) }

    // Calculate the size for each item based on the width of the grid divided by the number of columns
    val itemSize = if (gridSize.width > 0) gridSize.width / INVENTORY_COLUMNS else 0

    Box(
        modifier = Modifier
            .weight(3f)
            .background(Color.Black)
            .onGloballyPositioned { coordinates ->
                // Capture the width of the column after it's laid out
                gridSize = coordinates.size
            },
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(INVENTORY_COLUMNS),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(Player.inventory.size) { index ->
                Button(
                    onClick = { }, modifier = Modifier
                        .size(itemSize.dp),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    Text(
                        text = Player.inventory[index],
                    )
                }
            }
        }
    }
}