import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoardView(
    state: BoardViewState
) {
    val (boardSize, fruits, snakeHead, snakeBody) = state
    val boxSize = 30.dp
    val boxModifier = Modifier
        .size(boxSize)
        .height(boxSize)
        .border(Dp.Hairline, Color.Black)
        .padding(2.dp)
    Column {
        for (i in (0 until boardSize)) {
            Row {
                for (j in (0 until boardSize)) {
                    val p = Point(i, j)
                    when {
                        p == snakeHead -> SnakeHeadView(boxModifier)
                        snakeBody.contains(p) -> SnakeBodyView(boxModifier)
                        fruits.contains(p) -> FruitView(boxModifier)
                        else -> Box(boxModifier)
                    }
                }
            }
        }
    }
}

@Composable
fun SnakeHeadView(modifier: Modifier) {
    Box(modifier.background(Color.Green))
}

@Composable
fun SnakeBodyView(modifier: Modifier) {
    Box(modifier.background(Color.LightGray))
}

@Composable
fun FruitView(modifier: Modifier) {
    Box(modifier.background(Color.Red))
}