data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    enum class Direction(val movement: Point) {
        UP(Point(0, 1)),
        LEFT(Point(-1, 0)),
        DOWN(Point(0, -1)),
        RIGHT(Point(1, 0))
    }
}
