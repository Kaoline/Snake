class GameMaster(
    boardSize: Int
) {
    val snake: Snake
    val board: Board

    init {
        board = Board(boardSize)
        snake = Snake(board.getCenter())
        requestNewFruit()
    }

    private fun requestNewFruit() {
        val obstacles = snake.whole
        board.addFruit(obstacles)
    }

    fun moveSnake(direction: Point.Direction) {
        val newPosition = snake.head + direction.movement

        // Out of bounds case
        if (!board.contains(newPosition)) {
            return
        }

        snake.move(direction.movement)

        // Fruit resolution

        // Win case
    }
}