import kotlin.random.Random

interface Player {
    val name : String
    var currentDoor : Door?
    fun chooseDoor(count : Int) = Random.nextInt().mod(count)
    fun changeDoor(door: Door) : Boolean // true - согласен, false - против
}

class ConsoleChangingPlayer(override val name: String) : Player {
    override var currentDoor: Door? = null

    override fun changeDoor(door: Door): Boolean {
        currentDoor = door
        return true
    }
}

class ConsoleNoChangingPlayer(override val name: String) : Player {
    override var currentDoor: Door? = null

    override fun changeDoor(door: Door): Boolean {
        return false
    }
}