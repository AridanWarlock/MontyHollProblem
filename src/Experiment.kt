import kotlin.random.Random

abstract class Experiment(protected val player: Player, count: Int = 3)
{
    protected var doors : MutableList<Door> = ArrayList()
    protected val doorCount = if (count < 3) 3 else count

    abstract fun conductOneExperiment() : Boolean

    fun conductSeveralExperiment(count: Int) : Int { // Возвращает число успехов
        var result = 0

        for (i in 0..<count)
            if (conductOneExperiment())
                result++

        return result
    }

    protected fun randomiseDoors() {
        doors = MutableList(doorCount) { Door(Goat()) }

        doors[Random.nextInt().mod(doorCount)] = Door(ConsoleAuto())
    }
}

class ConsoleExperiment(player: Player, count: Int = 3) : Experiment(player, count) {
    override fun conductOneExperiment(): Boolean {
        randomiseDoors()
        val presenter = ConsolePresenter(player, doors)

        presenter.firstAskPlayer()

        val closedDoors = presenter.openDoors()

        if (closedDoors.size != 2)
            throw ArrayStoreException()

        if (closedDoors[0] != player.currentDoor)
            presenter.offerPlayerToChangeDoor(closedDoors[0])
        else
            presenter.offerPlayerToChangeDoor(closedDoors[1])

        return player.currentDoor?.prize is Auto
    }
}