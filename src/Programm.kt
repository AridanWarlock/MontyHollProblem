fun main()
{
    val doorCount = 5 // Число дверей в эксперименте
    val experimentCount = 10_000 // Число экспериментов

    // Меняющий свое мнение, адаптивный +_+
    val changingPlayer : Player = ConsoleChangingPlayer("Valt Nichilomius")

    var experiment = ConsoleExperiment(changingPlayer, doorCount)
    var countOfAuto = experiment.conductSeveralExperiment(experimentCount) // Число успехов

    println("\n\tМеняющий дверь")
    println("Ожидаемая вероятность: ${(doorCount - 1) / doorCount.toDouble()}")

    val changingProbability = countOfAuto / experimentCount.toDouble() // Вероятность успеха
    println("Полученная статистически: $changingProbability")

    // Упёртый баран, не слышал про теорию вероятности
    val noChangingPlayer : Player = ConsoleNoChangingPlayer("Aridan Warlock")

    experiment = ConsoleExperiment(noChangingPlayer, doorCount)
    countOfAuto = experiment.conductSeveralExperiment(experimentCount)

    println("\n\tНеменяющий дверь")
    println("Ожидаемая вероятность: ${1 / doorCount.toDouble()}")

    val noChangingProbability = countOfAuto / experimentCount.toDouble() // Вероятность успеха
    println("Полученная статистически: $noChangingProbability")

    println("\nИтог: менять дверь примерно в ${changingProbability / noChangingProbability} раз выгоднее")
}