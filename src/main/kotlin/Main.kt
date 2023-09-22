//imports
import kotlin.random.Random

fun main() {
    //variable to keep main game loop running
    var hasbeensolved = false

    //setting up colors
    // Everything after this is in red
    val colorpurple = "\u001b[38;5;165m"
    // Resets previous color codes
    val colorreset = "\u001b[0m"

    //creating the solution colors and order as a list, will be used to compare against user inputs to see if user is correct
    val solutionlist = listOf(Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7))
    println("solution is: $solutionlist this line is for testing, remove in final build")

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
        var onlistitem = 0

        for (item in guess) {
            when {
                (item == solutionlist[onlistitem]) -> correctcounter++
                (solutionlist.contains(item) == true) -> correctbutwrongspotcounter++
            }
            onlistitem++
        }

        if (correctcounter == 4) {
            println("wowie holy cow no way you did it so cool omg")
            break
        }

        //printing results of user input list compared to solution list
        println("you got " + colorpurple +correctcounter + colorreset + " correct number(s) in the right spot!")
        println("you got " + colorpurple +correctbutwrongspotcounter + colorreset + " number(s) correct but in the wrong spot")

        //testing just to make sure that the input was processed properly
        println("your guess was $guess this line is for testing, remove in final build.")

    }

}