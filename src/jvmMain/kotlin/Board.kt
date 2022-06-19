import kotlin.random.Random

data class Board(
    val size: Int
) {
    private val rand = Random(1)

    private val _fruits = mutableListOf<Fruit>()
    val fruits: List<Fruit> = _fruits

    fun getCenter() = Point(size / 2, size / 2)

    fun contains(point: Point): Boolean {
        return point.x in (0 until size) && point.y in (0 until size)
    }

    fun addFruit(obstacles: List<Point>) {
        var newFruit: Fruit
        do newFruit = Fruit(rand.nextInt(size), rand.nextInt(size))
        while (obstacles.contains(newFruit))
        _fruits.add(newFruit)
    }
}