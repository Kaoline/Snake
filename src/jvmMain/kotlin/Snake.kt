data class Snake(
    private var position: Point,
    private var size: Int = 1
) {
    private val _whole = mutableListOf(position)
    val whole = _whole
    val head = _whole.first()
    val body = _whole.drop(1)
}