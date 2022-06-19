data class BoardViewState(
    val size: Int,
    val fruits: List<Fruit>,
    val snakeHeadPosition: Point,
    val snakeBodyPosition: List<Point>
)
