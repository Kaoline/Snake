import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainViewModel(
    gameMaster: GameMaster
) {
    var boardViewState by mutableStateOf(BoardViewState(
        size = gameMaster.board.size,
        fruits = gameMaster.board.fruits,
        snakeHeadPosition = gameMaster.snake.head,
        snakeBodyPosition = gameMaster.snake.body
    ))
        private set
}