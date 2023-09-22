//imports
import kotlin.random.Random

fun main() {
    //variable to keep main game loop running
    var hasbeensolved = false

    //creating the solution colors and order as a list, will be used to compare against user inputs to see if user is correct
    val solutionlist = listOf(Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7))

    println("welcome!")

    //main game loop
    while (hasbeensolved == false) {

        //taking user input
        println("guess 4 numbers from 1 to 6 seperated by only commas. eg: 4,6,5,1")
        var guessstrings = readln().split(",")

        //testing user input to make sure its formatted properly and won't break the map function
        // also to make sure that user is only inputting 4 numbers from  1 to 6
        if (guessstrings.count() != 4) {
            println("input syntax wrong, try again.")
            break
        }
        if (guessstrings.filterNot { s -> (s == "1") || (s == "2") || (s == "3") || (s == "4") || (s == "5") || (s == "6") }.isNotEmpty()) {
            println("input syntax wrong, try again.")
            break
        }

        //turning user input into proper formatting (formatted as a list of integers, just like the solution list)
        var guess = guessstrings.map { it.toInt() }

        //setting up counters that will be used to display how the user scored for each input.
        // formatted as just counters as to not give away any info on positioning.
        var correctcounter = 0
        var correctbutwrongspotcounter = 0

        println(guess)


        hasbeensolved = true
    }

}