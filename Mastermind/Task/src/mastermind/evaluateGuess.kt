package mastermind

import kotlin.math.min

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val indexes = secret.zip(guess).count{c -> c.first == c.second}
    val similarLetter = "ABCDEF".sumBy{ letter -> min(secret.count{it == letter}, guess.count{it ==letter}) }
    val wrongPosition = similarLetter - indexes

    return Evaluation(indexes, wrongPosition)
}
