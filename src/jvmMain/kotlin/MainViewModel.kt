import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainViewModel(
    private val gameMaster: GameMaster
) {
    var boardViewState by mutableStateOf(makeBoardViewState())
        private set

    private fun makeBoardViewState(): BoardViewState {
        return BoardViewState(
            size = gameMaster.board.sideSize,
            fruits = gameMaster.board.fruits,
            snakeHeadPosition = gameMaster.snake.head,
            snakeBodyPosition = gameMaster.snake.body
        )
    }

    fun onDirectionInput(direction: Point.Direction) {
        gameMaster.moveSnake(direction)
        // Hack cause I'm too lazy to put some proper observable pattern
        boardViewState = makeBoardViewState()
    }
}