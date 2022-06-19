class Snake(
    startPosition: Point
) : ArrayList<Point>() {
    init {
        add(startPosition)
    }

    val head
        get() = first()
    val body
        get() = drop(1)

    fun move(delta: Point) {
        add(0, head + delta)
        removeLast()
    }

    fun grow() {
        add(last())
    }
}