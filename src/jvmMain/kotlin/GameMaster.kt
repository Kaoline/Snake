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

        // Out of board
        if (!board.contains(newPosition)) {
            return MoveResult.LostGame
        }

        // Self-collision
        if (snake.contains(newPosition)) {
            return MoveResult.LostGame
        }

        // Fruit resolution
        if (board.fruits.contains(newPosition)) {
            snake.grow()
            board.removeFruit(newPosition)
            snake.move(direction.movement)
            board.addFruit(snake)
        } else {
            snake.move(direction.movement)
        }

        // Win case
        if (snake.size == board.size) {
            return MoveResult.WonGame
        }

        return MoveResult.MoveDone
    }

    enum class MoveResult {
        MoveDone,
        LostGame,
        WonGame
    }
}