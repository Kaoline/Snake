import kotlin.random.Random

data class SquareBoard(
    val sideSize: Int
) {
    private val rand = Random(1)

    val size = sideSize * sideSize

    private val _fruits = mutableListOf<Fruit>()
    val fruits: List<Fruit> = _fruits

    fun getCenter() = Point(sideSize / 2, sideSize / 2)

    fun contains(point: Point): Boolean {
        return point.x in (0 until sideSize) && point.y in (0 until sideSize)
    }

    fun addFruit(obstacles: List<Point>) {
        var newFruit: Fruit
        do newFruit = Fruit(rand.nextInt(sideSize), rand.nextInt(sideSize))
        while (obstacles.contains(newFruit))
        _fruits.add(newFruit)
    }

    fun removeFruit(fruit: Fruit) {
        _fruits.remove(fruit)
    }
}