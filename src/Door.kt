class Door(private val _prize: Prize) {
    val prize : Prize
        get() = _prize

    var isOpen = false // Задел под GUI
        private set

    fun openDoor() : Prize { // Задел под GUI, запускаться будет кнопкой
        isOpen = true
        return _prize
    }
}