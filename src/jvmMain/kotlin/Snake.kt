data class Snake(
    private var startPosition: Point,
    private var size: Int = 1
) {
    private val _whole = mutableListOf(startPosition)
    val whole = _whole
    val head
        get() = _whole.first()
    val body
        get() = _whole.drop(1)

    fun move(delta: Point) {
        _whole.add(0, head + delta)
        _whole.removeLast()
    }
}