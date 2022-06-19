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
}