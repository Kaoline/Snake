class GameMaster(
    boardSize: Int
) {
    val snake: Snake
    val board: SquareBoard

    init {
        board = SquareBoard(boardSize)
        snake = Snake(board.getCenter())
        requestNewFruit()
    }

    private fun requestNewFruit() {
        val obstacles = snake
        board.addFruit(obstacles)
    }

    fun moveSnake(direction: Point.Direction): MoveResult {
        val newPosition = snake.head + direction.movement

        // Out of board case
        if (!board.contains(newPosition)) {
            return MoveResult.LostGame
        }

        // Self-collision case
        if (snake.contains(newPosition)) {
            return MoveResult.LostGame
        }

        // Fruit "collision" case
        if (board.fruits.contains(newPosition)) {
            snake.grow()
            board.removeFruit(newPosition)
        }

        // Move
        snake.move(direction.movement)

        // Win case
        if (snake.size == board.size) {
            return MoveResult.WonGame
        }

        // No existing fruit case
        if (board.fruits.isEmpty()) {
            board.addFruit(snake)
        }

        return MoveResult.MoveDone
    }

    enum class MoveResult {
        MoveDone,
        LostGame,
        WonGame
    }
}