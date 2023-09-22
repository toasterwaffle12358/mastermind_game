//imports
import kotlin.random.Random

fun main() {
    var hasbeensolved = false
    val solutionlist = listOf(Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7))
    println("welcome!")
    while (hasbeensolved == false) {
        println("guess 4 numbers from 1 to 6 seperated by only commas. eg: 4,6,5,1")
        var guessstrings = readln().split(",")
        if (guessstrings.count() != 4) {
            println("input syntax wrong, try again.")
            break
        }
        var guess = guessstrings.map { it.toInt() }
        println(guess)


        hasbeensolved = true
    }

}