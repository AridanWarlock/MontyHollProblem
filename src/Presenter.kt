abstract class Presenter(protected val player: Player, protected val doors: MutableList<Door>) {
    abstract fun firstAskPlayer()
    abstract fun offerPlayerToChangeDoor(door: Door) : Boolean
    abstract fun openDoors() : MutableList<Door>
}

class ConsolePresenter(player: Player, doors: MutableList<Door>) : Presenter(player, doors)
{
    override fun firstAskPlayer() {
        val doorIndex = player.chooseDoor(doors.count())
        player.currentDoor = doors[doorIndex]
    }

    override fun offerPlayerToChangeDoor(door: Door) : Boolean = player.changeDoor(door)

    override fun openDoors() : MutableList<Door> {
        if (doors.count() <= 2)
            return doors

        if (player.currentDoor!!.prize !is Auto)
            return doors.filter { it.prize is Auto || it == player.currentDoor }.toMutableList()

        return mutableListOf(player.currentDoor!!, Door(Goat())) // Player изначально угадал машину
    }
}